package com.ueg.nutshellbackend.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "FORNECEDOR")
public class Fornecedor extends PessoaJuridica{

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;

}



