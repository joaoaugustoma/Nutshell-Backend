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
//    public List<Fornecedor> findAllByFiltro(FornecedorDTO fornecedorDTO) {
//        Map<String, Object> parametros = new HashMap<>();
//        StringBuilder jpql = new StringBuilder();
//        jpql.append(" SELECT DISTINCT fornecedor FROM Fornecedor fornecedor");
//        jpql.append(" WHERE 1=1 ");
//
//        if (!Util.isEmpty(fornecedorDTO.getNome())) {
//            jpql.append(" AND fornecedor.razaoSocial = :razaoSocial ");
//            parametros.put("razaoSocial", fornecedorDTO.getNome());
//        }
//        if (!Util.isEmpty(fornecedorDTO.getCnpj())) {
//            jpql.append(" AND fornecedor.cpfCnpj = :cpfCnpj ");
//            parametros.put("cpfCnpj", fornecedorDTO.getCnpj());
//        }
//        if (fornecedorDTO.getStatus() != null) {
//            jpql.append(" AND fornecedor.situacao = :situacao ");
//            parametros.put("situacao", fornecedorDTO.getStatus());
//        }
//
//        jpql.append(" ORDER BY fornecedor.razaoSocial ASC ");
//
//        TypedQuery<Fornecedor> query = entityManager.createQuery(jpql.toString(), Fornecedor.class);
//        parametros.entrySet().forEach(parametro -> query.setParameter(parametro.getKey(), parametro.getValue()));
//        return query.getResultList();
//    }
}
