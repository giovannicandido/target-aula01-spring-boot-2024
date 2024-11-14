package br.com.eadtt.aula01.controller;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FabricanteControllerIntegTest {

    @Test
    void givenDataInDatase_shouldReturnAll() {

    }
}