package com.ueg.nutshellbackend.application.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TipoTelefone {

    CELULAR(1L, "Celular"), RESIDENCIAL(2L, "Residencial"), COMERCIAL(3L, "Comercial");

    private final Long id;

    private final String descricao;

    TipoTelefone(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static TipoTelefone getById(final Long id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }
}
