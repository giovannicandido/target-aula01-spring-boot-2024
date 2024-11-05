package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento")
@SequenceGenerator(name = "atendimento_seq", sequenceName = "atendimento_seq")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"}) // opcional
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento_seq")
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime dataAtendimento;

    private LocalDateTime dataFinalizacao;

    @Column(nullable = false)
    private BigDecimal valorAtendimento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Carro carro;

    @OneToOne
    @JoinColumn(nullable = false)
    private EntradaCarro entradaCarro;
}
