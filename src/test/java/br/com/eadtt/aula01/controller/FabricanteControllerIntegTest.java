package br.com.eadtt.aula01.controller;


import br.com.eadtt.aula01.data.FabricanteServiceData;
import br.com.eadtt.aula01.repository.FabricanteRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FabricanteControllerIntegTest extends TestContainerSetup {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FabricanteServiceData fabricanteServiceData;

    @Autowired
    private FabricanteRepository fabricanteRepository;

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
    void givenDataInDatase_shouldReturnOne() throws Exception {

    }
}