package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class NotaFiscal {
    @Id
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    private LocalDateTime data;
    private BigDecimal valorTotal;

    @ManyToMany
    @JoinTable(
            name = "nota_fiscal_peca_vendidas",
         joinColumns = @JoinColumn(
                 name = "id_nota",
                 foreignKey = @ForeignKey(name = "fk_peca_nota_fiscal")
         ),
         inverseJoinColumns = @JoinColumn(
                 name = "id_peca",
                 foreignKey = @ForeignKey(name = "fk_nota_fiscal_peca")
         )
    )
    private List<Peca> pecas;
}
