package com.ueg.nutshellbackend.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ueg.nutshellbackend.common.util.Util;

import java.io.Serializable;

public class TelefoneDTO implements Serializable {

    private String id;
    private String idPessoa;
    private String numero;
    private Long idTipo;
    private String descricaoTipo;
    private String ddd;


    @JsonIgnore
    public Long getIdLong() {
        Long idLong = null;

        if (!Util.isEmpty(id)) {
            idLong = Long.parseLong(id);
        }
        return idLong;
    }
}
