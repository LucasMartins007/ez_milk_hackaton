package com.hackaton.ezmilk.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RegistroDTO {

    private Integer id;

    private TipoRegistroDTO tipoRegistro;

    private TipoRegistroFilhoDTO tipoRegistroFilho;

    private BigDecimal preco;

    private BigDecimal porcentagem;

    private BigDecimal quantidade;

    private boolean isEntrada;

    private Date dataRegistro;

}
