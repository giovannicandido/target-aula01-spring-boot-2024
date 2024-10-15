package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.DeleteOficinaFilter;
import br.com.eadtt.aula01.model.Oficina;
import br.com.eadtt.aula01.repository.OficinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OficinaService {
    private final OficinaRepository oficinaRepository;

    public List<Oficina> findAll() {
        return oficinaRepository.findAll();
    }

    @Transactional
    public Oficina save(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @Transactional
    public void deleteById(Integer id) {
        oficinaRepository.deleteById(id);
    }

    @Transactional
    public void deleteEmBatch(DeleteOficinaFilter filter) {
        if(filter.getIds() != null && !filter.getIds().isEmpty()) {
//            oficinaRepository.deleteAllById(filter.getIds());
            oficinaRepository.deleteAllOficinaById(filter.getIds());
        }
        // trim tira espaco em branco
        if(filter.getNome() != null && !filter.getNome().trim().isEmpty()) {
            String nomeLike = filter.getNome() + "%";
            oficinaRepository.deleteByNome(nomeLike);
        }

    }
}
