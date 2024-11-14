package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.Constants;
import br.com.eadtt.aula01.controller.response.CarroResponse;
import br.com.eadtt.aula01.controller.response.CarroResponseList;
import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.service.CarroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = CarroController.class)
class CarroControllerTest {

    @MockBean
    private CarroService carroServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void given_CarrosList_whenGetAllCarros_thenReturnListOfCarros() throws Exception {

        List<Carro> carrosReturn = List.of(
                Carro.builder()
                        .marca("Fiat")
                        .build(),
                Carro.builder()
                        .modelo("Fusca")
                        .build()
        );

        doReturn(carrosReturn)
                .when(carroServiceMock).getCarrosByFilter(any());

        MvcResult mvcResult = mockMvc.perform(get(Constants.V0 + "/carros"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        CarroResponseList carroResponseList = mapper.readValue(json, CarroResponseList.class);

        assertThat(carroResponseList.getCarros()).hasSize(2);

        List<String> marcas = carroResponseList.getCarros().stream().map(CarroResponse::getMarca).toList();
        assertThat(marcas).contains("Fiat");
    }

    @Test
    void given_CarrosList_whenGetAllCarros_thenReturnListOfCarros2() throws Exception {

        List<Carro> carrosReturn = List.of(
                Carro.builder()
                        .marca("Fiat")
                        .build(),
                Carro.builder()
                        .marca("")
                        .modelo("Fusca")
                        .build()
        );

        doReturn(carrosReturn)
                .when(carroServiceMock).getCarrosByFilter(any());

        mockMvc.perform(get(Constants.V0 + "/carros"))
                .andExpect(jsonPath("$.carros", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.carros[*].marca", Matchers.containsInAnyOrder("Fiat", "")))
        ;

//        String json = mvcResult.getResponse().getContentAsString();
//
//        CarroResponseList carroResponseList = mapper.readValue(json, CarroResponseList.class);
//
//        assertThat(carroResponseList.getCarros()).hasSize(2);
//
//        List<String> marcas = carroResponseList.getCarros().stream().map(CarroResponse::getMarca).toList();
//        assertThat(marcas).contains("Fiat");
    }

}