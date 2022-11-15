package com.ueg.nutshellbackend.application.repository.impl;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepositoryCustom;
import com.ueg.nutshellbackend.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Fornecedor> findAllByFiltro(FornecedorDTO filtroDTO) {
        Map<String, Object> parametros = new HashMap<>();
        StringBuilder jpql = new StringBuilder();
        jpql.append(" SELECT DISTINCT fornecedor FROM Fornecedor fornecedor");
        jpql.append(" WHERE 1=1 ");

        if (!Util.isEmpty(filtroDTO.getNome())) {
            jpql.append(" AND fornecedor.nome = :nome ");
            parametros.put("nome", filtroDTO.getNome());
        }
        if (!Util.isEmpty(filtroDTO.getCnpj())) {
            jpql.append(" AND fornecedor.cnpj = :cnpj ");
            parametros.put("cnpj", filtroDTO.getCnpj());
        }
        if (filtroDTO.getStatus() != null) {
            jpql.append(" AND fornecedor.status = :status ");
            parametros.put("status", filtroDTO.getStatus());
        }

        jpql.append(" ORDER BY fornecedor.nome ASC ");

        TypedQuery<Fornecedor> query = entityManager.createQuery(jpql.toString(), Fornecedor.class);
        parametros.forEach(query::setParameter);
        return query.getResultList();

    }
}
