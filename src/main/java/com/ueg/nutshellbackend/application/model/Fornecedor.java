package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity()
@Table(name = "FORNECEDOR")
public class Fornecedor extends PessoaJuridica{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PESSOA")
    @Column(name = "ID_PESSOA", nullable = false)
    private Long idPessoa;

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

    @Override
    public Long getIdPessoa() {
        return idPessoa;
    }

    @Override
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}



