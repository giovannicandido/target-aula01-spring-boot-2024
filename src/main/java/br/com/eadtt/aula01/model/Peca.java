package br.com.eadtt.aula01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Peca {

    @Id
    private Integer id;
    private String nome;
    private BigDecimal preco;

    @ManyToMany(mappedBy = "pecas")
    private List<NotaFiscal> notasEmitidas;
}
