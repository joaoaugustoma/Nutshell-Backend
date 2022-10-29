package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;

@Mapper(componentModel = "spring", uses = { StatusAtivoInativoMapper.class})
public interface FornecedorMapper  {

    FornecedorDTO toDTO(Fornecedor fornecedor);

    Fornecedor toEntity(FornecedorDTO fornecedorDTO);
}

