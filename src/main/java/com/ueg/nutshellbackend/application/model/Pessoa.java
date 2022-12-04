package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.enums.converter.StatusAtivoInativoConverter;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;

import javax.persistence.*;
import java.util.Set;

@SequenceGenerator(name = "S_PESSOA", sequenceName = "S_PESSOA", allocationSize = 1, schema = Constante.DATABASE_OWNER)
@Inheritance(strategy=InheritanceType.JOINED)
@Entity(name = "PESSOA")
public class Pessoa extends GenericTabela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PESSOA")
    @Column(name = "ID_PESSOA", nullable = false)
    private Long idPessoa;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Contato> contatos;

    @Convert(converter = StatusAtivoInativoConverter.class)
    @Column(name = "STATUS", nullable = false, length = 1)
    private StatusAtivoInativo status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }

    public StatusAtivoInativo getStatus() {
        return status;
    }

    public void setStatus(StatusAtivoInativo status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
