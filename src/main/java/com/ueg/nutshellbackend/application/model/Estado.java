package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity(name = "ESTADO")
public class  Estado {

    @Id
    @Column(name = "ID_ESTADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100, name = "NOME")
    private String nome;

    @Column(nullable = false, length = 2, name = "UF")
    private String uf;

    @ManyToOne()
    @JoinColumn(name = "ID_PAIS")
    private Pais pais;

    @OneToMany(mappedBy = "estado",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Cidade> cidadeSet;

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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Set<Cidade> getCidadeSet() {
        return cidadeSet;
    }

    public void setCidadeSet(Set<Cidade> cidadeSet) {
        this.cidadeSet = cidadeSet;
    }
}