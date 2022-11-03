package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.enums.converter.StatusAtivoInativoConverter;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;

import javax.persistence.*;
import java.util.Set;

@SequenceGenerator(name = "S_PESSOA", sequenceName = "S_PESSOA", allocationSize = 1, schema = Constante.DATABASE_OWNER)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "PESSOA")
public class Pessoa extends GenericTabela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PESSOA")
    @Column(name = "ID_PESSOA", nullable = false)
    private Long idPessoa;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefone> telefones;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Convert(converter = StatusAtivoInativoConverter.class)
    @Column(name = "STATUS", nullable = false, length = 1)
    private StatusAtivoInativo status;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

//    @Column(name = "CIDADE", nullable = false)
//    private Cidade cidade;
//
//    @Column(name = "ESTADO", nullable = false)
//    private Estado estado;


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

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusAtivoInativo getStatus() {
        return status;
    }

    public void setStatus(StatusAtivoInativo status) {
        this.status = status;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
