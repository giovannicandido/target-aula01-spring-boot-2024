package br.com.eadtt.aula01.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cliente_endereco_residencial_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_endereco_residencial"))
    private Endereco enderecoResidencial;

    @OneToOne
    @JoinColumn(name = "cliente_endereco_comercial_id", foreignKey = @ForeignKey(name = "fk_cliente_endereco_comercial"))
    private Endereco enderecoComercial;
}
