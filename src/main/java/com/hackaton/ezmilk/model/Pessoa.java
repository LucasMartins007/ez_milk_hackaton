package com.hackaton.ezmilk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Pessoa {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_usuario", allocationSize = 1, sequenceName = "gen_id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_usuario")
    private Integer id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pessoa_to_tecnico"))
    private Tecnico tecnico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propriedade")
    private Propriedade propriedade;
}
