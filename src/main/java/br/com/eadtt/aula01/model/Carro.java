package br.com.eadtt.aula01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "carro")
public class Carro {
    @Id
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;
}
