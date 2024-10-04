package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.controller.response.CarroResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
@AllArgsConstructor
public class CarroResponseList {

    private List<CarroResponse> carros;
}
