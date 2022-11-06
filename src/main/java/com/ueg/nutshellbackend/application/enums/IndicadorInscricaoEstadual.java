package com.ueg.nutshellbackend.application.enums;

import java.util.Arrays;

public enum IndicadorInscricaoEstadual {
    NAO_CONTRIBUINTE("0", "Não Contribuinte"),
    CONSUMIDOR_FINAL("1", "Consumidor Final"),
    CONTRIBUINTE("2", "Contribuinte");

    private final String id;
    private final String descricao;

    IndicadorInscricaoEstadual(final String id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static IndicadorInscricaoEstadual getById(final String id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
