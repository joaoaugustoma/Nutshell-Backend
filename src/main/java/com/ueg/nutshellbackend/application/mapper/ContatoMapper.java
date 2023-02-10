package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.dto.ContatoDTO;
import com.ueg.nutshellbackend.application.model.Contato;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ContatoMapper {

    ContatoDTO toDTO(Contato contato);

    Contato toEntity(ContatoDTO contatoDTO);
}
