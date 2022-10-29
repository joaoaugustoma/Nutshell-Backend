package com.ueg.nutshellbackend.application.enums.converter;

import com.ueg.nutshellbackend.application.enums.TipoTelefone;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TipoTelefoneConverter implements AttributeConverter<TipoTelefone, Long> {

    @Override
    public Long convertToDatabaseColumn(TipoTelefone tipoTelefone) {
        return tipoTelefone != null ? tipoTelefone.getId() : null;
    }

    @Override
    public TipoTelefone convertToEntityAttribute(Long id) {
        return TipoTelefone.getById(id);
    }

}
