package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;
import com.ueg.nutshellbackend.common.exception.BusinessException;
import com.ueg.nutshellbackend.common.exception.MessageCode;
import com.ueg.nutshellbackend.common.exception.MessageResponse;
import com.ueg.nutshellbackend.common.exception.NotFoundException;
import org.aspectj.bridge.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<TABELA extends GenericTabela, TABELA_DTO, TYPE_PK> {

    EntityManager entityManager;

    public TABELA salvar(TABELA tabela){
        validarCamposObrigatorios(tabela);
        if(validarIdNull(tabela)){
            prepararInclusao(tabela);
        }else {
            prepararEdicao(tabela);
        }

        executarSalvar(tabela);
        return tabela;
    }

    public TABELA listarById(TYPE_PK typePk ) {
        Optional<TABELA> tabela = getRepository().findById(typePk);
        if(tabela.isPresent()){
            return tabela.get();
        }else {
            throw new BusinessException(MessageCode.ERRO_NENHUM_REGISTRO_ENCONTRADO);
        }
    }

    public List<TABELA> listarTudo(){
        List<TABELA> tabelas = getRepository().findAll();

        if(tabelas.isEmpty()){
            throw new BusinessException(MessageCode.ERRO_NENHUM_REGISTRO_ENCONTRADO);
        }

      return tabelas;
    };

    private void executarSalvar(TABELA tabela) {
        getRepository().save(tabela);
    }

    private boolean validarIdNull(TABELA tabela) {
        return tabela.getIdValue(tabela) == null;
    };

    protected abstract JpaRepository<TABELA, TYPE_PK> getRepository();

    protected abstract void prepararEdicao(TABELA tabela);

    protected abstract void prepararInclusao(TABELA tabela);

    public abstract void validarCamposObrigatorios(TABELA tabela);

}
