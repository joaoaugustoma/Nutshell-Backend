package com.ueg.nutshellbackend.application.repository;

import com.ueg.nutshellbackend.application.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, FornecedorRepositoryCustom {

    Fornecedor findByCnpj(final String cnpj);

    Long countByCnpj(final String cnpj);

}
