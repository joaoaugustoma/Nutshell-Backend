package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.enums.TipoTelefone;
import com.ueg.nutshellbackend.application.enums.converter.TipoTelefoneConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TELEFONE", schema= Constante.DATABASE_OWNER)
@EqualsAndHashCode(of = { "ddd", "numero" })
@SequenceGenerator(name = "S_TELEFONE", sequenceName = "S_TELEFONE", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public @Data class Telefone implements Serializable {
    private static final long serialVersionUID = -3928643077340896948L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_TELEFONE")
    @Column(name = "ID_TELEFONE", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA", nullable = false)
    private Pessoa pessoa;

    @Column(name = "NUMR_TELEFONE_USUARIO", length = 11, nullable = false)
    private String numero;

    @Column(name = "TIPO_TELEFONE", nullable = false, length = 1)
    @Convert(converter = TipoTelefoneConverter.class)
    private TipoTelefone tipo;

    @Column(name = "DDD_TELEFONE", length = 5)
    private Long ddd;
}
