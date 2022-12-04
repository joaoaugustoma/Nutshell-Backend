package com.ueg.nutshellbackend.application.enums.converter;

import com.ueg.nutshellbackend.application.enums.TipoTelefone;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TipoTelefoneConverter implements AttributeConverter<TipoTelefone, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoTelefone tipoTelefone) {
        return tipoTelefone != null ? tipoTelefone.getId() : null;
    }

    @Override
    public TipoTelefone convertToEntityAttribute(Integer id) {
        return TipoTelefone.getById(id);
    }

}
