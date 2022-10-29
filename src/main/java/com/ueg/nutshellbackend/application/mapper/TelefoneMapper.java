package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.dto.TelefoneDTO;
import com.ueg.nutshellbackend.application.model.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { FornecedorMapper.class })
public interface TelefoneMapper {

    public TelefoneDTO toDTO(Telefone telefone);

    public Telefone toEntity(TelefoneDTO telefoneUsuarioDTO);
}
