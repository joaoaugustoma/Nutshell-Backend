package com.ueg.nutshellbackend.application.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusAtivoInativo {
    ATIVO("1", "Ativo"),
    INATIVO("1", "Inativo");

    private String id;
    private String descricao;

    StatusAtivoInativo(final String id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static StatusAtivoInativo getById(final String id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }

    public static StatusAtivoInativo getById(final boolean id) {
        return id ? StatusAtivoInativo.ATIVO : StatusAtivoInativo.INATIVO;
    }
}
