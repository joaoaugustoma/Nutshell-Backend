package com.ueg.nutshellbackend.application.enums.converter;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class IndicadorInscricaoEstadualConverter implements AttributeConverter<IndicadorInscricaoEstadual, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IndicadorInscricaoEstadual indicadorInscricaoEstadual) {
        return indicadorInscricaoEstadual != null ? indicadorInscricaoEstadual.getId() : null;
    }

    @Override
    public IndicadorInscricaoEstadual convertToEntityAttribute(Integer s) {
        return IndicadorInscricaoEstadual.getById(s);
    }
}
