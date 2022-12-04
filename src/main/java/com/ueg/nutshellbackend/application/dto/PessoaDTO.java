package com.ueg.nutshellbackend.application.dto;

import com.ueg.nutshellbackend.application.model.Contato;
import com.ueg.nutshellbackend.application.model.Telefone;

import java.io.Serializable;
import java.util.Set;

public class PessoaDTO implements Serializable {
    private Long idPessoa;
    private String nome;
    private Set<ContatoDTO> contatos;
    private String status;
    private EnderecoDTO endereco;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ContatoDTO> getContatos() {
        return contatos;
    }

    public void setContatos(Set<ContatoDTO> contatos) {
        this.contatos = contatos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
