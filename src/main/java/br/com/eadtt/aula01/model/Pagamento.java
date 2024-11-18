package br.com.eadtt.aula01.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "pagamento_seq", sequenceName = "pagamento_seq")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento_seq")
    private Integer id;

    @ManyToOne
    private Atendimento atendimento;
    private BigDecimal valor;
    private LocalDateTime dataHoraPagamento;
}
