package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Integer> {
}
