package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrada_carro")
@Getter
@Setter
public class EntradaCarro {

    @Id
    private Integer id;

    @ManyToOne
    private Carro carro;

    @ManyToOne
    private Oficina oficina;

    private LocalDateTime dataEntrada;
}
