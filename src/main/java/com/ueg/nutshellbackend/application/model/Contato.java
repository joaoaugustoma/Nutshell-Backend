package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "CONTATO")
@SequenceGenerator(name = "S_CONTATO", sequenceName = "S_CONTATO", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CONTATO")
    @Column(name = "ID_CONTATO", nullable = false)
    private Long idContato;

    @Column(length = 300, name = "NOME", nullable = false)
    private String nome;

    @Column(length = 300, name = "EMAIL", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TELEFONE_PRINCIPAL", nullable = false)
    private Telefone telefonePrincipal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TELEFONE_SECUNDARIO")
    private Telefone telefoneSecundario;

    @Column(name = "CONTATO_PRINCIPAL", nullable = false)
    private Boolean isContatoPrincipal;

    @ManyToOne()
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

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

    public Boolean getContatoPrincipal() {
        return isContatoPrincipal;
    }

    public void setContatoPrincipal(Boolean contatoPrincipal) {
        isContatoPrincipal = contatoPrincipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Telefone getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(Telefone telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public Telefone getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(Telefone telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }
}
