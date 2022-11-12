package com.ueg.nutshellbackend.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PAIS", uniqueConstraints = {@UniqueConstraint(columnNames={"NOME"})})
public class Pais {

    @Id
    @Column(name = "ID_PAIS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30, name = "NOME")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    @Column(name = "ID_PAIS")
    private Set<Estado> estados;

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

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }
}
