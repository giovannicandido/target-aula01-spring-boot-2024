package br.com.eadtt.aula01.controller.response;


import br.com.eadtt.aula01.model.Carro;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarroResponseListTest {

    @Test
    void givenCarroList_when_fromModel_shouldContainCarroResponse() {
        Carro carro =  Carro.builder()
                .ano(2024)
                .modelo("Uno")
                .marca("Fiat")
                .build();

        List<Carro> carrosModel = List.of(
            carro
        );


        CarroResponse expectedResponse = CarroResponse.fromModel(carro);

        CarroResponseList carroResponseList = CarroResponseList.fromModel(carrosModel);

        assertThat(carroResponseList.getCarros())
                .contains(expectedResponse);

    }
}