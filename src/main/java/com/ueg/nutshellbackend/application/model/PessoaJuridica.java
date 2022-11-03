package com.ueg.nutshellbackend.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@PrimaryKeyJoinColumn(name="idPessoa")
@Entity(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "IE", nullable = false)
    private String inscricaoEstadual;

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
}
