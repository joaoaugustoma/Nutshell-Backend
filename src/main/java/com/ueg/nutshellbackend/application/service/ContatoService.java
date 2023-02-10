package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.annotation.RepositoryName;
import com.ueg.nutshellbackend.application.model.Contato;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
@RepositoryName("ContatoRepository")
public class ContatoService extends AbstractService<Contato, Long>{

    @Override
    protected void prepararEdicao(Contato tabela) {

    }

    @Override
    protected void prepararInclusao(Contato tabela) {

    }

    @Override
    protected void depoisSalvar(Contato tabela) {

    }


}
