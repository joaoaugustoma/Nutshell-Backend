package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class IndicadorInscricaoEstadualMapper {
    public IndicadorInscricaoEstadual asIndicadorInscricaoEstadual(Integer valor){
        return IndicadorInscricaoEstadual.getById(valor);
    }

    public Integer asInteger(Integer valor){
        return switch (valor) {
            case 0 -> (IndicadorInscricaoEstadual.NAO_CONTRIBUINTE.getId());
            case 1 -> (IndicadorInscricaoEstadual.CONSUMIDOR_FINAL.getId());
            case 2 -> (IndicadorInscricaoEstadual.CONTRIBUINTE.getId());
            default -> null;
        };
    }
}

