package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.repository.EntradaCarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EntradaCarroService {
    private final EntradaCarroRepository entradaCarroRepository;

    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean darBaixaEntrada(Integer idEntrada) {
        LocalDateTime now = LocalDateTime.now();
        // Usando com ifPresent o compilador do java vai reclamar de acesso concorrent nessa variavel, por isso atomicboolean
//        AtomicBoolean baixa = new AtomicBoolean(false);
        return entradaCarroRepository.findById(idEntrada)
                        .map(entradaCarro -> {
                            entradaCarro.setDataSaida(now);
                            entradaCarroRepository.save(entradaCarro);
                            return true;
                        }).orElse(false);
//        entradaCarroRepository.findById(idEntrada)
//                .ifPresent(entradaCarro -> {
//                    entradaCarro.setDataSaida(now);
//                    entradaCarroRepository.save(entradaCarro);
//                    baixa.set(true);
//                });
//
//        return baixa.get();
    }
}
