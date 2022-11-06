package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import com.ueg.nutshellbackend.application.enums.converter.IndicadorInscricaoEstadualConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@PrimaryKeyJoinColumn(name="idPessoa")
@Entity(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;

    @Column(name = "INSCRICAO_MUNICIPAL", nullable = false)
    private String inscricaoMunicipal;

    @Convert(converter = IndicadorInscricaoEstadualConverter.class)
    @Column(name = "INDICADOR_INSCRICAO_ESTADUAL", nullable = false)
    private IndicadorInscricaoEstadual indicadorInscricaoEstadual;

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

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public IndicadorInscricaoEstadual getIndicadorInscricaoEstadual() {
        return indicadorInscricaoEstadual;
    }

    public void setIndicadorInscricaoEstadual(IndicadorInscricaoEstadual indicadorInscricaoEstadual) {
        this.indicadorInscricaoEstadual = indicadorInscricaoEstadual;
    }
}
