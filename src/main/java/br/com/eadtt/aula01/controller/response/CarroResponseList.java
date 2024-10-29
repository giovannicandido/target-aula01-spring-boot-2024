package br.com.eadtt.aula01.controller.response;

import br.com.eadtt.aula01.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
@AllArgsConstructor
public class CarroResponseList {

    private List<CarroResponse> carros;

    public static CarroResponseList fromModel(List<Carro> carros) {
        if (carros == null || carros.isEmpty()) {
            return new CarroResponseList(new ArrayList<>());
        }
        return new CarroResponseList(carros.stream().map(CarroResponse::fromModel).toList());
    }
}
