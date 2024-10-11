package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.repository.CarroRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CarroService {
    private final CarroRepository carroRespository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRespository = carroRepository;
    }

    public List<Carro> getAllCarros() {
       return carroRespository.findAll();
    }

    public Carro save(Carro carro) {
        return carroRespository.save(carro);
    }

    public void deleteById(Integer id) {
        carroRespository.deleteById(id);
    }
}
