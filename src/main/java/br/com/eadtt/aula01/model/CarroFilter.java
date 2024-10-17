package br.com.eadtt.aula01.model;

import lombok.Value;

@Value
public class CarroFilter {
    private final String marca;
    private final String modelo;
}
