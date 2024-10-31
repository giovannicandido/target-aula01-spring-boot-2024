package br.com.eadtt.aula01.service;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.model.DeleteOficinaFilter;
import br.com.eadtt.aula01.model.Oficina;
import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.repository.EntradaCarroRepository;
import br.com.eadtt.aula01.repository.OficinaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OficinaService {
    private final OficinaRepository oficinaRepository;
    private final EntradaCarroRepository entradaCarroRepository;
    private final EntradaCarroService entradaCarroService;

    public List<Oficina> findAll() {
        return oficinaRepository.findAll();
    }

    @Transactional(noRollbackFor = EntityNotFoundInDatabaseException.class, value = "projetoMapsTransactionManager", transactionManager = "projetoMapsTransactionManager" )
    public Oficina save(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @Transactional
    public void deleteById(Integer id) {
        oficinaRepository.deleteById(id);
    }

    @Transactional
    public void deleteEmBatch(DeleteOficinaFilter filter) {
        if (filter.getIds() != null && !filter.getIds().isEmpty()) {
//            oficinaRepository.deleteAllById(filter.getIds());
            oficinaRepository.deleteAllOficinaById(filter.getIds());
        }
        // trim tira espaco em branco
        if (filter.getNome() != null && !filter.getNome().trim().isEmpty()) {
            String nomeLike = filter.getNome() + "%";
            oficinaRepository.deleteByNome(nomeLike);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void darBaixa(Oficina oficina) {
        /// Checar status com a prefeitura
        /// Dar baixa no estoque
        // o @Transaction do metodo interno é ignorado
        darBaixaEmEstoque(oficina);
        /// Dar baixa nos carros
        entradaCarroService.darBaixaEntrada(oficina.getId());
    }

    // chamada interna não tem proxy
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void darBaixaEmEstoque(Oficina oficina) {

    }

    public List<Carro> findEntradasByOficina(Integer oficinaId) {
        // usando query nativa
//        return entradaCarroRepository.getAllByOficinaId(oficinaId)
//                .stream().map(
//                        objects -> new Carro(Integer.parseInt(objects[0].toString()), objects[1].toString(),
//                                objects[1].toString(), null, null, null)
//                ).toList();

//        return entradaCarroRepository.getCarroEntradaByOficinaId(oficinaId);
        return entradaCarroRepository.getCarroResumoEntradaByOficinaId(oficinaId)
                .stream()
                .map(projection -> Carro.builder()
                        .id(projection.getId())
                        .marca(projection.getMarca())
                        .modelo(projection.getModelo())
                        .build())
                .toList();
    }

    public boolean verificarOcupacao(Integer oficinaId) {
        Oficina oficina = oficinaRepository.findById(oficinaId)
                .orElseThrow(() -> new EntityNotFoundInDatabaseException("Oficina", oficinaId.toString()));

        Long count = entradaCarroRepository.getCarrosNaOficina(oficinaId)
                .stream().count();
        // Por exemplo verificar tempo de ocupação maxima por veiculo e emitir um alerta.
        // Consistencia eventual no alerta.
        // Emitir o evento de alerta.
        return oficina.getOcupacaoMaxima() <= count;
    }
}
