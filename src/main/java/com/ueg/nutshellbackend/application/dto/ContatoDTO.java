package com.ueg.nutshellbackend.application.dto;

public class ContatoDTO {
    private Long idContato;
    private String nome;
    private String email;
    private TelefoneDTO telefonePrincipal;
    private TelefoneDTO telefoneSecundario;
    private Boolean isContatoPrincipal;

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TelefoneDTO getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(TelefoneDTO telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public TelefoneDTO getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(TelefoneDTO telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public Boolean getContatoPrincipal() {
        return isContatoPrincipal;
    }

    public void setContatoPrincipal(Boolean contatoPrincipal) {
        isContatoPrincipal = contatoPrincipal;
    }
}
