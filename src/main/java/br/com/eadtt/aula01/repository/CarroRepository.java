package br.com.eadtt.aula01.repository;

import br.com.eadtt.aula01.model.Carro;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("prototype")
public class CarroRepository {
    private List<Carro> carros = new ArrayList<>(
            List.of(
                    new Carro(1, "Ford", "Fiesta", 2023),
                    new Carro(2, "Fiat", "Uno - Com escada", 2022)
            )
    );

    public List<Carro> findAll() {
       return carros;
    }

    public Carro save(Carro carro) {
        Integer id = carros.size() + 1;
        carro.setId(id);
        carros.add(carro);
        return carro;
    }
}
