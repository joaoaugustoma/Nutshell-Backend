package com.ueg.nutshellbackend.application.repository.impl;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepositoryCustom;
import com.ueg.nutshellbackend.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FornecedorRepositoryImpl implements FornecedorRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

//    @Override
//    public List<Fornecedor> listarByFiltro(FornecedorDTO filtroDTO) {
//        Map<String, Object> parametros = new HashMap<>();
//        StringBuilder jpql = new StringBuilder();
//        jpql.append(" SELECT DISTINCT fornecedor FROM Fornecedor fornecedor");
//        jpql.append(" WHERE 1=1 ");
//
//        if (!Util.isEmpty(filtroDTO.getNome())) {
//            jpql.append(" AND fornecedor.razaoSocial = :razaoSocial ");
//            parametros.put("razaoSocial", filtroDTO.getNome());
//        }
//        if (!Util.isEmpty(filtroDTO.getCnpj())) {
//            jpql.append(" AND fornecedor.cpfCnpj = :cpfCnpj ");
//            parametros.put("cpfCnpj", filtroDTO.getCnpj());
//        }
//        if (filtroDTO.getStatus() != null) {
//            jpql.append(" AND fornecedor.situacao = :situacao ");
//            parametros.put("situacao", filtroDTO.getStatus());
//        }
//
//        jpql.append(" ORDER BY fornecedor.razaoSocial ASC ");
//
//        TypedQuery<Fornecedor> query = entityManager.createQuery(jpql.toString(), Fornecedor.class);
//        parametros.forEach(query::setParameter);
//        return query.getResultList();
//
//        return null;
//    }
}
