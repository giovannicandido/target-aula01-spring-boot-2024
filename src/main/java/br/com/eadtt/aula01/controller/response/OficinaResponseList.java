package br.com.eadtt.aula01.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OficinaResponseList {
    private List<OficinaResponse> oficinas;
}
