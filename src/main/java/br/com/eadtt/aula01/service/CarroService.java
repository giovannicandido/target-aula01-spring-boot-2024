package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.model.CarroFilter;
import br.com.eadtt.aula01.model.Cliente;
import br.com.eadtt.aula01.model.Fabricante;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.repository.CarroRepository;
import br.com.eadtt.aula01.repository.ClientRepository;
import br.com.eadtt.aula01.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRespository;
    private final FabricanteRepository fabricanteRepository;
    private final ClientRepository clientRepository;

    public List<Carro> getAllCarros() {
        return carroRespository.findAll();
    }

    @Transactional
    public Carro save(Carro carro, Integer fabricanteId, Integer donoId) {
        Fabricante fabricante = fabricanteRepository.findById(fabricanteId)
                .orElseThrow(() -> new EntityNotFoundInDatabaseException("Fabricante", fabricanteId.toString()));

        // Busca dados do cliente sem usar
        Cliente cliente = clientRepository.findById(donoId)
                        .orElseThrow(() -> new EntityNotFoundInDatabaseException("Cliente", donoId.toString()));

        carro.setFabricante(fabricante);
        carro.setDono(cliente);
        return carroRespository.save(carro);
    }

    @Transactional
    public void deleteById(Integer id) {
        carroRespository.deleteById(id);
    }

    public List<Carro> getCarrosByMarca(String marca) {
        return carroRespository.getAllByMarca(marca);
    }

    public List<Carro> getCarrosByModelo(String modelo) {
        return carroRespository.getAllByModelo(modelo);
    }

    public List<Carro> getCarrosByFilter(CarroFilter filters) {
        Carro carro = new Carro();
        carro.setMarca(filters.getMarca());
        carro.setModelo(filters.getModelo());
        Example<Carro> example = Example.of(carro);
        return carroRespository.findAll(example, Sort.unsorted());

    }

    public List<Carro> getCarrosByAno(Integer ano) {
        // Geralmenta usa-se varios repositories
        return carroRespository.getAllByAnoOrMarca(ano, "Ford");
    }
}
