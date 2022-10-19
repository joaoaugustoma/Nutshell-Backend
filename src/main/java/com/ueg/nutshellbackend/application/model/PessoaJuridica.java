package com.ueg.nutshellbackend.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(name="idPessoa")
@Entity(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Column(name = "IE", nullable = false)
    private String inscricaoEstadual;
}
