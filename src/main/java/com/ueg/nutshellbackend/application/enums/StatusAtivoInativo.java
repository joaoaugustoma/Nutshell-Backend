package com.ueg.nutshellbackend.application.enums;

import java.util.Arrays;

public enum StatusAtivoInativo {
    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo");

    private final String id;
    private final String descricao;

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

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
