package br.com.eadtt.aula01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Fabricante {
    @Id
    private Integer id;

    @OneToOne
    private Endereco endereco;

    // Como é bidirecional se acessar a lista de carros no java o JPA/hibernate vai fazer uma query e buscar os carros do fabricante.
    @OneToMany(mappedBy = "fabricante")
    private List<Carro> carros;
}
