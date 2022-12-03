package com.ueg.nutshellbackend.application.enums;

import java.util.Arrays;

public enum IndicadorInscricaoEstadual {
    NAO_CONTRIBUINTE(0, "Não Contribuinte"),
    CONTRIBUINTE(1, "Contribuinte");

    private final Integer id;
    private final String descricao;

    IndicadorInscricaoEstadual(final Integer id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static IndicadorInscricaoEstadual getById(final Integer id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
