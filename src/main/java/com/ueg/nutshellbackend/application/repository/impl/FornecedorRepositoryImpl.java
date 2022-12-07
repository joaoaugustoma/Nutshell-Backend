package com.ueg.nutshellbackend.application.repository.impl;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.FornecedorRepositoryCustom;
import com.ueg.nutshellbackend.common.exception.BusinessException;
import com.ueg.nutshellbackend.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FornecedorRepositoryImpl implements FornecedorRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Fornecedor> listarByFiltro(FornecedorDTO filtroFornecedor) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Fornecedor> criteriaQuery = criteriaBuilder.createQuery(Fornecedor.class);

        Root<Fornecedor> fornecedorRoot = criteriaQuery.from(Fornecedor.class);
        List<Predicate> predicates = new ArrayList<>();

        if(Util.isNotNull(filtroFornecedor.getNome())){
            predicates.add(criteriaBuilder.like(fornecedorRoot.get("nome"), "%" + filtroFornecedor.getNome() + "%"));
        }
        if(Util.isNotNull(filtroFornecedor.getCnpj())){
            predicates.add(criteriaBuilder.like(fornecedorRoot.get("cnpj"), "%" + filtroFornecedor.getCnpj()));
        }
        if(Util.isNotNull(filtroFornecedor.getStatus())){
            if(filtroFornecedor.getStatus().equals("A") || filtroFornecedor.getStatus().equals("I")){
                predicates.add(criteriaBuilder.equal(fornecedorRoot.get("status"), StatusAtivoInativo.getById(filtroFornecedor.getStatus())));
            } else {
                throw new RuntimeException("Campo status com valor inválido!");
            }
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
