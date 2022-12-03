package com.ueg.nutshellbackend.application.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CIDADE", uniqueConstraints = {@UniqueConstraint(columnNames={"NOME", "ID_ESTADO"})})
public class Cidade {

    @Id
    @Column(name = "ID_CIDADE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200, name = "NOME")
    private String nome;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

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
}