package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Fabricante;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    @Transactional
    public Fabricante create(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public List<Fabricante> findAll() {
        return fabricanteRepository.findAll();
    }

    public Fabricante findById(Integer id) {
        return fabricanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundInDatabaseException("Fabricante", id.toString()));
    }
}
