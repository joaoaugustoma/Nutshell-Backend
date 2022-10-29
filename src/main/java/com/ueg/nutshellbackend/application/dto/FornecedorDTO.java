package com.ueg.nutshellbackend.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ueg.nutshellbackend.application.annotation.Campo;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Telefone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FornecedorDTO extends PessoaJuridicaDTO implements Serializable {

    private String cnpj;
    private String nome;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String email;
    private String status;
    private String cep;
    private String endereco;
    private Set<Telefone> telefones;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

}
