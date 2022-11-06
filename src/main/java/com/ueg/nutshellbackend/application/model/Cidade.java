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

    @Column(nullable = false, name = "CODIGO_IBGE")
    private Integer codigoIbge;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @Column(nullable = false, name = "DATA_ATUALIZACAO")
    private LocalDate dataAtualizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}