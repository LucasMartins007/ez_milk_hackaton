package com.hackaton.ezmilk.model;

import com.hackaton.ezmilk.model.enums.EnumStatusRegistro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Registro {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "id_registro", allocationSize = 1, sequenceName = "gen_id_registro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_registro")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_registro")
    private TipoRegistro tipoRegistro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_registro_filho")
    private TipoRegistroFilho tipoRegistroFilho;

    private EnumStatusRegistro statusRegistro;

    private BigDecimal preco;

    private BigDecimal quantidade;

    private boolean isEntrada;

    @Temporal(TemporalType.DATE)
    private Date dataRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_registro_to_usuario"))
    private Pessoa pessoa;

}
