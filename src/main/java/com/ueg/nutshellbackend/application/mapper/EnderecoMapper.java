package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.dto.EnderecoDTO;
import com.ueg.nutshellbackend.application.model.Endereco;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoDTO toDTO(Endereco fornecedor);

    Endereco toEntity(EnderecoDTO fornecedorDTO);
}
