package com.ueg.nutshellbackend.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "FORNECEDOR")
public class Fornecedor extends PessoaJuridica{

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}



