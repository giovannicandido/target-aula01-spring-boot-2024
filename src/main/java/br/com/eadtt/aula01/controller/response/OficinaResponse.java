package br.com.eadtt.aula01.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaResponse {
    private Integer id;
    private String nome;
}
