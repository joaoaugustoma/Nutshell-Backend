package com.ueg.nutshellbackend.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ueg.nutshellbackend.application.enums.TipoTelefone;
import com.ueg.nutshellbackend.common.util.Util;

import java.io.Serializable;

public class TelefoneDTO implements Serializable {

    private String idTelefone;
    private String numero;
    private String tipo;
    private String ddd;

    public String getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(String idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
