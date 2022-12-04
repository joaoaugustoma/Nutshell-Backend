package com.ueg.nutshellbackend.application.model;

import com.ueg.nutshellbackend.application.configuration.Constante;
import com.ueg.nutshellbackend.application.enums.TipoTelefone;
import com.ueg.nutshellbackend.application.enums.converter.TipoTelefoneConverter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity(name = "TELEFONE")
@SequenceGenerator(name = "S_TELEFONE", sequenceName = "S_TELEFONE", allocationSize = 1, schema = Constante.DATABASE_OWNER)
public class Telefone implements Serializable {

    @Serial
    private static final long serialVersionUID = -3928643077340896948L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_TELEFONE")
    @Column(name = "ID_TELEFONE", nullable = false)
    private Long idTelefone;

    @Column(name = "NUMR_TELEFONE_USUARIO", length = 11, nullable = false)
    private String numero;

    @Column(name = "TIPO_TELEFONE", nullable = false, length = 1)
    @Convert(converter = TipoTelefoneConverter.class)
    private TipoTelefone tipo;

    @Column(name = "DDD_TELEFONE", length = 5)
    private String ddd;

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long id) {
        this.idTelefone = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}
