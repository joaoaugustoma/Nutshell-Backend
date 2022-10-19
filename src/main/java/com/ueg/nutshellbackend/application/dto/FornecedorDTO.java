package com.ueg.nutshellbackend.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FornecedorDTO extends PessoaJuridicaDTO implements Serializable {

}
