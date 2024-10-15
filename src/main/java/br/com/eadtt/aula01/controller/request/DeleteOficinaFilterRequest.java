package br.com.eadtt.aula01.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class DeleteOficinaFilterRequest {
    private List<Integer> ids;
    private String nome;
}
