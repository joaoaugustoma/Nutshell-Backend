package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "FORNECEDOR")
public class Fornecedor extends PessoaJuridica{

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
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



