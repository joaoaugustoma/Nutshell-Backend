package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "ESTADO", uniqueConstraints = {@UniqueConstraint(columnNames={"NOME", "ID_PAIS"})})
public class  Estado {

    @Id
    @Column(name = "ID_ESTADO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100, name = "NOME")
    private String nome;

    @Column(nullable = false, length = 2, name = "UF")
    private String uf;

    @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
    @Column(name = "ID_ESTADO")
    private Set<Cidade> cidades;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAIS")
    private Pais pais;

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


    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}