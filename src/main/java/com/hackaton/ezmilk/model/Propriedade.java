package com.hackaton.ezmilk.model;

import com.hackaton.ezmilk.model.enums.EnumStatusRegistro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Propriedade {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_propriedade", allocationSize = 1, sequenceName = "gen_id_propriedade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_propriedade")
    private Integer id;

    private String nome;

    @Convert(converter = EnumStatusRegistro.EnumConverter.class)
    private EnumStatusRegistro statusPropriedade;

    private Integer latitude;

    private Integer longitude;

}
