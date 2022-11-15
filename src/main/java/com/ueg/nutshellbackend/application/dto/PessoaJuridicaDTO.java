package com.ueg.nutshellbackend.application.dto;

import java.io.Serializable;

public class PessoaJuridicaDTO extends PessoaDTO implements Serializable {
    private String cnpj;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String indicadorInscricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getIndicadorInscricaoEstadual() {
        return indicadorInscricaoEstadual;
    }

    public void setIndicadorInscricaoEstadual(String indicadorInscricaoEstadual) {
        this.indicadorInscricaoEstadual = indicadorInscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }
}
