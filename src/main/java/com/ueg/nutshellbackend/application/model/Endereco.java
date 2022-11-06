package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ENDERECO", schema= Constante.DATABASE_OWNER)
@SequenceGenerator(name = "S_ENDERECO", sequenceName = "S_ENDERECO", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = -3928643077340896948L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ENDERECO")
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(nullable = true, length = 100, name = "LOGRADOURO")
    private String logradouro;

    @Column(nullable = true, length = 10, name = "NUMERO_ENDERECO")
    private String numeroEndereco;

    @Column(nullable = true, length = 150, name = "COMPLEMENTO")
    private String complemento;

    @Column(nullable = true, length = 100, name = "BAIRRO")
    private String bairro;

    @ManyToOne(optional = true, fetch= FetchType.LAZY)
    @JoinColumn(name = "ID_CIDADE")
    private Cidade cidade;

    @Column(nullable = true, length = 10, name = "CEP")
    private String cep;

    @Column(nullable = false, name = "ENDERECO_PRINCIPAL")
    private Boolean isEnderecoPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA", nullable = false)
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getEnderecoPrincipal() {
        return isEnderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        isEnderecoPrincipal = enderecoPrincipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}