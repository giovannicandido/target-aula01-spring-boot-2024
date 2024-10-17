package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.model.CarroFilter;
import br.com.eadtt.aula01.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
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
        String queryString = "select c from Carro c ";

        if(filters.getModelo() != null || filters.getMarca() != null) {
            queryString += " where ";
        }

        if (filters.getModelo() != null) {
            queryString += " c.modelo = :modelo";
        }

        if (filters.getMarca() != null) {
            queryString += " and c.marca = :marca";
        }

        TypedQuery<Carro> query = entityManager.createQuery(queryString, Carro.class);
        if (filters.getModelo() != null) {
            query.setParameter("modelo", filters.getModelo());
        }

        if (filters.getMarca() != null) {
            query.setParameter("marca", filters.getMarca());
        }
        return query.getResultList();

    }
}
