package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Esse repository é implementado pelo spring data
 * Já possui varios metodos para persistencia de dados
 * Vamos criar novos
 */
public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

    @Query("delete from Oficina o where o.id in :ids")
    @Modifying
    public void deleteAllOficinaById(@Param("ids") List<Integer> ids);

    @Query("delete from Oficina o where o.nome like :nome")
    @Modifying
    void deleteByNome(@Param("nome") String nome);
}
