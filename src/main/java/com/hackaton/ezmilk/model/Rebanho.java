package com.hackaton.ezmilk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Rebanho {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_rebanho", allocationSize = 1, sequenceName = "gen_id_rebanho")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_rebanho")
    private Integer id;

    private Integer quantidadeTotal;

    private Integer lactacao;

    private Integer seca;

    private Integer novilha;

    private Integer bezerra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

}
