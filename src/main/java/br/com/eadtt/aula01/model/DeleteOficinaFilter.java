package br.com.eadtt.aula01.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class DeleteOficinaFilter {
    private List<Integer> ids;
    private String nome;
}
