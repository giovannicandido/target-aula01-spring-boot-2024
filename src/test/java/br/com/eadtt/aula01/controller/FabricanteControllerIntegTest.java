package br.com.eadtt.aula01.controller;


import br.com.eadtt.aula01.data.FabricanteServiceData;
import br.com.eadtt.aula01.model.Fabricante;
import br.com.eadtt.aula01.repository.FabricanteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FabricanteControllerIntegTest extends TestContainerSetup {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FabricanteServiceData fabricanteServiceData;

    @Autowired
    private ObjectMapper objectMapper;

    // é OK fazer o setup dos dados no banco e limpar sempre apos cada testes enquanto o junit executa sequencialmente
    // porem quando crescer e for executar em paralelo isso tem que ser revisto.
    @BeforeEach
    public void setup() {
        fabricanteServiceData.create();
    }

    @AfterEach
    public void tearDown() {
        fabricanteServiceData.clean();
    }

    @Test
    void givenDataInDatase_shouldReturnAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v0/fabricantes"))
                .andExpect(jsonPath("$.fabricantes", Matchers.hasSize(3)));
    }

    @Test
    void givenFabricanteIdNotInDatabase_shouldReturnNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v0/fabricantes/9999999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title", Matchers.is("Entity not found in Database")))
                .andExpect(jsonPath("$.detail", Matchers.is("Fabricante not found in Database with id 9999999")))
        ;
    }

    @Test
    void givenInvalidFabricante_shouldValidateJson() throws Exception {
        Fabricante fabricante = new Fabricante();
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/v0/fabricantes")
                        .content(objectMapper.writeValueAsString(fabricante))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        MvcResult mvcResult = resultActions.andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();

        resultActions.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title", Matchers.is("Invalid Request")))
                .andExpect(jsonPath("$.messages[*]", Matchers
                        .containsInAnyOrder("nome: must not be blank", "endereco: must not be null")));

    }
}