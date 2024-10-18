package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.model.CarroFilter;
import br.com.eadtt.aula01.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    private final EntityManager entityManager;

    public List<Carro> getAllCarros() {
        return carroRespository.findAll();
    }

    @Transactional
    public Carro save(Carro carro) {
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
}
