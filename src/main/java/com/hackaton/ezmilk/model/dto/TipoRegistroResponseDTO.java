package com.hackaton.ezmilk.model.dto;

import com.hackaton.ezmilk.model.enums.EnumStatusRegistro;
import lombok.Data;

@Data
public class TipoRegistroResponseDTO {

    private Integer id;

    private String descricao;

    private EnumStatusRegistro statusRegistro;

}
