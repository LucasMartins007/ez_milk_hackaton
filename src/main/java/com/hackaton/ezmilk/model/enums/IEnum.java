package com.hackaton.ezmilk.model.enums;


public interface IEnum<E> {

    String getValue();

    @SuppressWarnings("rawtypes")
    default String getName() {
        return ((Enum) this).name();
    }

}
