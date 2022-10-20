package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;

public abstract class AbstractService<TABELA extends GenericTabela> {

    public TABELA salvar(TABELA tabela){
        validarCamposObrigatorios(tabela);
        validarFornecedorDuplicadoPorCnpj(tabela);
        return tabela;
    };

    public abstract Boolean validarCamposObrigatorios(TABELA tabela);

    public abstract Boolean validarFornecedorDuplicadoPorCnpj(TABELA tabela);

    public abstract void executarSalvar();


}
