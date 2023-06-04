package com.hackaton.ezmilk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class TipoRegistro {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_tipo_registro", allocationSize = 1, sequenceName = "gen_id_tipo_registro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tipo_registro")
    private Integer id;

    private String descricao;

    private boolean isEntrada;

    @OneToMany(mappedBy = "tipoRegistro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TipoRegistroFilho> tipoRegistroFilho;

}
