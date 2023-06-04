package com.hackaton.ezmilk.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Converter;

@Getter
@RequiredArgsConstructor
public enum EnumStatusRegistro implements IEnum<String> {

    REGISTRO_DISCREPANTE("Registro com gastos acima do esperado."),

    REGISTRO_OK("Registro OK."),

    SEM_REGISTRO("Registro não inicializado"),

    REGISTRO_ATRASADO("Registro atrasado."),
    ;


    private final String value;

    @Converter
    public static class EnumConverter extends AbstractEnumConverter<EnumStatusRegistro, String> {
    }

}
