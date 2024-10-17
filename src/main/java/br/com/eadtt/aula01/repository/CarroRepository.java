package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Carro;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Exemplo de como usar o EntityManager do JPA sem spring data
 * O spring data usa o EntityManager para criar o padrão repository que ele implementada
 * O spring data é mais produtivo
 *
 */
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
