package com.julianna_fernandes.itau.itau_teste_tecnico.infrastructure;

public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity(String message) {
        super(message);
    }
}
