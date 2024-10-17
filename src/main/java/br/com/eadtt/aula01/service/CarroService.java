package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.repository.CarroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carroRespository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRespository = carroRepository;
    }

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
}
