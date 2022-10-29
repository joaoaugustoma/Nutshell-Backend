package com.ueg.nutshellbackend.application.enums.converter;

import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusAtivoInativoConverter implements AttributeConverter<StatusAtivoInativo, String> {

    @Override
    public String convertToDatabaseColumn(StatusAtivoInativo status) {
        return status != null ? status.getId() : null;
    }

    @Override
    public StatusAtivoInativo convertToEntityAttribute(String id) {
        return StatusAtivoInativo.getById(id);
    }

}
