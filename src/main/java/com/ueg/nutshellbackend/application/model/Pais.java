package com.ueg.nutshellbackend.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "PAIS")
public class Pais {

    @Id
    @Column(name = "ID_PAIS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30, name = "NOME")
    private String nome;

    @OneToMany(mappedBy = "pais",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Estado> estadoSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Estado> getEstadoSet() {
        return estadoSet;
    }

    public void setEstadoSet(Set<Estado> estadoSet) {
        this.estadoSet = estadoSet;
    }
}
