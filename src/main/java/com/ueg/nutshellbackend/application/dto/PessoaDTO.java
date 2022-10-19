package com.ueg.nutshellbackend.application.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PessoaDTO implements Serializable {

    private String nome;


    private Long idTipoAmigo;


    private LocalDate dataAmizade;


    private Boolean amigo;
}
