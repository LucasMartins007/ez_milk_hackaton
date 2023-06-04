package com.hackaton.ezmilk.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumDomainException implements IDomainException {
    NULL_POINTER_EXCEPTION("Null pointer");

    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
}
