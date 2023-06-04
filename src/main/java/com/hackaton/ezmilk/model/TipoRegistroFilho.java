package com.hackaton.ezmilk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TipoRegistroFilho {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_tipo_registro_filho", allocationSize = 1, sequenceName = "gen_id_tipo_registro_filho")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tipo_registro_filho")
    private Integer id;

    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_registro", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipo_registro_filho_to_tipo_registro"))
    private TipoRegistro tipoRegistro;

}
