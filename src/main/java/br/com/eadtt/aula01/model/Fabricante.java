package br.com.eadtt.aula01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "fabricante_seq", sequenceName = "fabricante_seq")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabricante_seq")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Endereco endereco;

    // Como é bidirecional se acessar a lista de carros no java o JPA/hibernate vai fazer uma query e buscar os carros do fabricante.
    @OneToMany(mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Carro> carros;
}
