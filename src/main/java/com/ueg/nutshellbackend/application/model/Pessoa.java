package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
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

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefone> telefones;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "STATUS", nullable = false)
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
}
