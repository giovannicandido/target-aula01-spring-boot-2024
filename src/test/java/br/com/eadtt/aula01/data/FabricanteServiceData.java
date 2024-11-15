package br.com.eadtt.aula01.data;

import br.com.eadtt.aula01.data.stub.FabricanteStub;
import br.com.eadtt.aula01.repository.FabricanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FabricanteServiceData {
    private final FabricanteRepository fabricanteRepository;

    public FabricanteServiceData(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    @Transactional
    public void create() {
        System.out.println("Rodando create");
        fabricanteRepository.saveAll(FabricanteStub.createList());
    }

    public void clean() {
        fabricanteRepository.deleteAll();
    }
}
