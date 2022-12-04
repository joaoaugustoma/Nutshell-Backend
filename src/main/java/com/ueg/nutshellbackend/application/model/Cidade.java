package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "CIDADE")
public class Cidade {

    @Id
    @Column(name = "ID_CIDADE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200, name = "NOME")
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @OneToMany(mappedBy = "cidade",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Endereco> enderecoSet;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Endereco> getEnderecoSet() {
        return enderecoSet;
    }

    public void setEnderecoSet(Set<Endereco> enderecoSet) {
        this.enderecoSet = enderecoSet;
    }
}