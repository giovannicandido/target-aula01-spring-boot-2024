package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
}
