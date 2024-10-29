package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Carro;
import br.com.eadtt.aula01.model.EntradaCarro;
import br.com.eadtt.aula01.repository.result.CarroProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntradaCarroRepository extends JpaRepository<EntradaCarro, Integer> {

    @Query(value = """
                    select c
                    from EntradaCarro ent
                             join ent.carro c
                             join c.fabricante fa
                             where ent.oficina.id = :oficinaId
            """)
    List<Carro> getCarroEntradaByOficinaId(@Param("oficinaId") Integer oficinaId);

    @Query(value = """
                    select c.id as id, c.modelo as modelo, c.marca as marca
                    from EntradaCarro ent
                             join ent.carro c
                             join c.fabricante fa
                             where ent.oficina.id = :oficinaId
            """)
    List<CarroProjection> getCarroResumoEntradaByOficinaId(Integer oficinaId);
    @Query(value = """
                    select c.id as id, c.modelo as modelo, c.marca as marca
                    from EntradaCarro ent
                             join ent.carro c
                             where ent.oficina.id = :oficinaId
                             and ent.dataSaida is null 
            """)
    List<CarroProjection> getCarrosNaOficina(Integer oficinaId);
}
