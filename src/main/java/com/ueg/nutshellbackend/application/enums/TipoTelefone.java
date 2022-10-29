package com.ueg.nutshellbackend.application.enums;

import lombok.Getter;

import java.util.Arrays;

public enum TipoTelefone {

    CELULAR(1L, "Celular"), RESIDENCIAL(2L, "Residencial"), COMERCIAL(3L, "Comercial");

    private final Long id;

    private final String descricao;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    TipoTelefone(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static TipoTelefone getById(final Long id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }
}
