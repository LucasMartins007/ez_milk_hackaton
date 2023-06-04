package com.hackaton.ezmilk.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HistoricoDTO {

    private List<RegistroDTO> registros;

    private BigDecimal saldoFinal;
}
