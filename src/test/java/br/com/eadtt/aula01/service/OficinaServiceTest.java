package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Oficina;
import br.com.eadtt.aula01.repository.EntradaCarroRepository;
import br.com.eadtt.aula01.repository.OficinaRepository;
import br.com.eadtt.aula01.repository.result.CarroProjection;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


class OficinaServiceTest {

    private OficinaRepository oficinaRepository = Mockito.mock(OficinaRepository.class);
    private EntradaCarroRepository entradaCarroRepository = Mockito.mock(EntradaCarroRepository.class);

    private EntradaCarroService entradaCarroService = new EntradaCarroService(entradaCarroRepository);

    @Test
    void givenOficinaExistent_whenVeficarOcupacao_thenReturnCorrectCount() {
        OficinaService oficinaService = new OficinaService(oficinaRepository, entradaCarroRepository, entradaCarroService);
        Oficina oficina = new Oficina();
        oficina.setOcupacaoMaxima(0);

        doReturn(Optional.of(oficina))
                .when(oficinaRepository)
                .findById(1);

        List<CarroProjection> carros = new ArrayList<>();
        CarroProjection carroProjection = mock(CarroProjection.class);
        carros.add(carroProjection);

        doReturn(carros)
                .when(entradaCarroRepository).getCarrosNaOficina(1);

        boolean result = oficinaService.verificarOcupacao(1);

        assertThat(result).isTrue();
    }
}