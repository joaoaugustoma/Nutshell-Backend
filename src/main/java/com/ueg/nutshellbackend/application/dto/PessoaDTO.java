package com.ueg.nutshellbackend.application.dto;

import com.ueg.nutshellbackend.application.model.Contato;
import com.ueg.nutshellbackend.application.model.Telefone;

import java.io.Serializable;
import java.util.Set;

public class PessoaDTO implements Serializable {
    private Long idPessoa;
    private String nome;
    private Set<Contato> contatos;
    private String email;
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

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
