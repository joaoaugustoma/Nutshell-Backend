package com.ueg.nutshellbackend.application.enums;

import java.util.Arrays;

public enum TipoTelefone {

    CELULAR(1, "Celular"),
    RESIDENCIAL(2, "Residencial"),
    COMERCIAL(3, "Comercial");

    private final Integer id;

    private final String descricao;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    TipoTelefone(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static TipoTelefone getById(final Integer id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }
}
