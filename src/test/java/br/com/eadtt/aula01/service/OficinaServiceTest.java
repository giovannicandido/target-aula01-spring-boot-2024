package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Oficina;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.repository.EntradaCarroRepository;
import br.com.eadtt.aula01.repository.OficinaRepository;
import br.com.eadtt.aula01.repository.result.CarroProjection;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


class OficinaServiceTest {

    private OficinaRepository oficinaRepository = Mockito.mock(OficinaRepository.class);
    private EntradaCarroRepository entradaCarroRepository = Mockito.mock(EntradaCarroRepository.class);

    private EntradaCarroService entradaCarroService = new EntradaCarroService(entradaCarroRepository);

    @Test
    void givenOficinaExistent_whenVeficarOcupacao_thenReturnCorrectCount() {
        OficinaService oficinaService = new OficinaService(oficinaRepository, entradaCarroRepository, entradaCarroService);
        Oficina oficina = new Oficina();
        oficina.setOcupacaoMaxima(2);

        doReturn(Optional.of(oficina))
                .when(oficinaRepository)
                .findById(1);

        List<CarroProjection> carros = new ArrayList<>();
        CarroProjection carroProjection = mock(CarroProjection.class);
        carros.add(carroProjection);

        doReturn(carros)
                .when(entradaCarroRepository).getCarrosNaOficina(anyInt());

        boolean result = oficinaService.verificarOcupacao(1);

        assertThat(result).isTrue();

        verify(entradaCarroRepository, times(1)).getCarrosNaOficina(1);
        verify(oficinaRepository, times(1)).findById(anyInt());
    }

    @Test
    void givenOficinaNotExist_whenVeficarOcupacao_thenThrowException() {
        // exemplo lançamento de exceção
//        doThrow(new EntityNotFoundException("Not found"))
//                .when(oficinaRepository)
//                .findById(2);
        doReturn(Optional.empty())
                .when(oficinaRepository)
                .findById(1);
        OficinaService oficinaService = new OficinaService(oficinaRepository, entradaCarroRepository, entradaCarroService);

        Object entityName = assertThatThrownBy(() -> {
            oficinaService.verificarOcupacao(2);
        }).isInstanceOf(EntityNotFoundInDatabaseException.class)
                .hasMessage(null);
//                .extracting("entityName");

//        assertThat(entityName).isSameAs("Oficina");
    }
}