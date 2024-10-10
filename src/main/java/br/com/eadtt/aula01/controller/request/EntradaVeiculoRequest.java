package br.com.eadtt.aula01.controller.request;

import lombok.Data;

@Data
public class EntradaVeiculoRequest {
    private Long idMecanico;
    private String cpfResponsavel;
    private String cpfDono;
    private CarroRequest carro;
}
