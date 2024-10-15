package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oficina")
@Getter
@Setter
@SequenceGenerator(name = "oficina_seq", sequenceName = "oficina_seq")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oficina_seq")
    private Integer id;

    @Column(length = 50, unique = true, nullable = false)
    private String nome;
}
