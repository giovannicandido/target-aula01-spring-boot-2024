package br.com.eadtt.aula01.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponse {
    private Integer id;
    private String marca;
    private String modelo;
    private Integer ano;
}
