package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "CONTATO")
@SequenceGenerator(name = "S_CONTATO", sequenceName = "S_CONTATO", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public class Contato extends GenericTabela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CONTATO")
    @Column(name = "ID_CONTATO", nullable = false)
    private Long idContato;

    @Column(length = 300, name = "NOME", nullable = false)
    private String nome;

    @Column(length = 300, name = "EMAIL", nullable = false)
    private String email;

    @Column(length = 2, name = "DDD", nullable = false)
    private String ddd;

    @Column(length = 9, name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "IS_FAV", nullable = false)
    private boolean isFav;

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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
