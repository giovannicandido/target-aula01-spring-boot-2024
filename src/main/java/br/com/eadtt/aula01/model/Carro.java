package br.com.eadtt.aula01.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Carro {
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;
}
