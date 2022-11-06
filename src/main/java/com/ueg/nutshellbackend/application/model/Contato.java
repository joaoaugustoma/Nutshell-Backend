package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;

import javax.persistence.*;

@Entity
@Table(name = "CONTATO", schema= Constante.DATABASE_OWNER)
@SequenceGenerator(name = "S_CONTATO", sequenceName = "S_CONTATO", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CONTATO")
    @Column(name = "ID_CONTATO", nullable = false)
    private Long id;

    @Column(nullable = false, length = 300, name = "NOME")
    private String nome;

    @Column(nullable = true, length = 300, name = "EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "TELEFONE_1", nullable = false)
    private Telefone telefone1;

    @OneToOne
    @JoinColumn(name = "TELEFONE_2", nullable = true)
    private Telefone telefone2;

    @Column(nullable = false, name = "CONTATO_PRINCIPAL")
    private Boolean isContatoPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA", nullable = false)
    private Pessoa pessoa;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Telefone telefone1) {
        this.telefone1 = telefone1;
    }

    public Telefone getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Telefone telefone2) {
        this.telefone2 = telefone2;
    }

    public Boolean getContatoPrincipal() {
        return isContatoPrincipal;
    }

    public void setContatoPrincipal(Boolean contatoPrincipal) {
        isContatoPrincipal = contatoPrincipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
