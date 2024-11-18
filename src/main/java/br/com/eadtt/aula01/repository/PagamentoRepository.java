package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    Optional<Pagamento> findByAtendimento_Id(Integer atendimentoId);
}
