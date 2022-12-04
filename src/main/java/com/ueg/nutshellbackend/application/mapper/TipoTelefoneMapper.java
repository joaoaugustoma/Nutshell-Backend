package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import com.ueg.nutshellbackend.application.enums.TipoTelefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class TipoTelefoneMapper {
    public TipoTelefone asTipoTelefone(Integer valor){
        return TipoTelefone.getById(valor);
    }

    public Integer asInteger(Integer valor){
        return switch (valor) {
            case 1 -> (TipoTelefone.CELULAR.getId());
            case 2 -> (TipoTelefone.RESIDENCIAL.getId());
            case 3 -> (TipoTelefone.COMERCIAL.getId());
            default -> null;
        };
    }
}

