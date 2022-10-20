package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;
import com.ueg.nutshellbackend.common.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<TABELA extends GenericTabela, TYPE_PK> {

    public TABELA salvar(TABELA tabela){
        validarCamposObrigatorios(tabela);
        validarFornecedorDuplicadoPorCnpj(tabela);
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
            throw new NotFoundException("Objeto não existente. Id não encontrado.");
        }
    }

    public List<TABELA> listarTudo(){
      return getRepository().findAll();
    };

    private void executarSalvar(TABELA tabela) {
        getRepository().save(tabela);
    }

    private boolean validarIdNull(TABELA tabela) {
        if(tabela.getIdValue(tabela) == null){
            return true;
        } else {
            return false;
        }
    };

    protected abstract JpaRepository getRepository();

    protected abstract void prepararEdicao(TABELA tabela);

    protected abstract void prepararInclusao(TABELA tabela);

    public abstract Boolean validarCamposObrigatorios(TABELA tabela);

    public abstract Boolean validarFornecedorDuplicadoPorCnpj(TABELA tabela);

}
