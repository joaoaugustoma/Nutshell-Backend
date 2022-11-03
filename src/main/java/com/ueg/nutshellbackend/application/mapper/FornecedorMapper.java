package com.ueg.nutshellbackend.application.mapper;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = { StatusAtivoInativoMapper.class })
public interface FornecedorMapper {

    public FornecedorDTO toDTO(Fornecedor fornecedor);

    public Fornecedor toEntity(FornecedorDTO fornecedorDTO);
}
