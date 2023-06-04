package com.hackaton.ezmilk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity

public class Tecnico {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_tecnico", allocationSize = 1, sequenceName = "gen_id_tecnico")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tecnico")
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pessoa> pessoas;


}
