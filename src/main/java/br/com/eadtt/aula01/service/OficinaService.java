package br.com.eadtt.aula01.service;

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
}
