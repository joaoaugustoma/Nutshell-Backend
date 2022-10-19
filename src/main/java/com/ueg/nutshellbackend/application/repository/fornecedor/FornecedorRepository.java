package com.ueg.nutshellbackend.application.repository.fornecedor;

import com.ueg.nutshellbackend.application.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, FornecedorRepositoryCustom {

    public Long findByCnpj(final String cnpj);

    public Long countByCnpj(final String cnpj);

//    @Query(" SELECT fornecedor FROM Fornecedor fornecedor "
//            + " WHERE fornecedor.cnpj = :cnpj "
//            + " AND(:idPessoa IS NULL OR fornecedor.idPessoa != :idPessoa)")
//    public Fornecedor findByCnpjAndNotIdPessoa(@Param("cnpj") final String cnpj, @Param("idPessoa") final Long idPessoa);


}
