package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
