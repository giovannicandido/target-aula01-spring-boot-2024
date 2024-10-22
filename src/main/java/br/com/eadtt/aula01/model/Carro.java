package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "carro")
@SequenceGenerator(name = "carro_seq", sequenceName = "carro_seq")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "carro_fabricante_id", nullable = false, foreignKey = @ForeignKey(name = "fk_carro_fabricante"))
    private Fabricante fabricante;

    @OneToOne
    private Cliente dono;
}
