package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Carro;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Exemplo de como usar o EntityManager do JPA sem spring data
 * O spring data usa o EntityManager para criar o padrão repository que ele implementada
 * O spring data é mais produtivo
 *
 */
@Repository
@RequiredArgsConstructor
public class CarroRepository {
    private final EntityManager em;

    public List<Carro> findAll() {
        List<Carro> carros = em.createQuery("select c from Carro c", Carro.class)
                .getResultList();
        return carros;
    }

    @Transactional
    public Carro save(Carro carro) {
        if(carro.getId() == null) {
            em.persist(carro);
        } else {
            em.merge(carro);
        }
        return carro;
    }

    public void deleteById(Integer id) {
        em.remove(em.find(Carro.class, id));
    }
}
