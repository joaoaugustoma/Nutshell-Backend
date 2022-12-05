package com.ueg.nutshellbackend.application.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FornecedorDTO extends PessoaJuridicaDTO implements Serializable {

    private LocalDate dataCadastro;
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
