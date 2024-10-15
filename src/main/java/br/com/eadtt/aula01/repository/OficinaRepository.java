package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {
}
