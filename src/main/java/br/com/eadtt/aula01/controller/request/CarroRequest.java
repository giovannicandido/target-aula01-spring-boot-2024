package br.com.eadtt.aula01.controller.request;

import lombok.Data;

@Data
public class CarroRequest {
    private String marca;
    private String modelo;
    private Integer ano;
    private String placaCarro;
}
