package com.ueg.nutshellfrontend.application.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "FORNECEDOR")
public class Fornecedor extends PessoaJuridica{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

}



