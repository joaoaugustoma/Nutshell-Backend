package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.model.reflection.GenericTabela;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FornecedorService extends AbstractService<Fornecedor, Long> {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    public void setFornecedorRepository(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository=fornecedorRepository;
    }

    @Override
    protected JpaRepository getRepository() {
        return  fornecedorRepository;
    }

    @Override
    protected void prepararEdicao(Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = listarById(fornecedor.getIdPessoa());


        fornecedor.setStatus(fornecedorExistente.getStatus());
        fornecedor.setDataCadastro(fornecedorExistente.getDataCadastro());
        fornecedor.setDataAtualizacao(LocalDate.now());
    }

    @Override
    protected void prepararInclusao(Fornecedor fornecedor) {
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        LocalDate data = LocalDate.now();
        fornecedor.setDataCadastro(data);
        fornecedor.setDataAtualizacao(data);
    }

    @Override
    public Boolean validarCamposObrigatorios(Fornecedor fornecedor) {
        return null;
    }

    @Override
    public Boolean validarFornecedorDuplicadoPorCnpj(Fornecedor fornecedor) {
        return null;
    }

    public Fornecedor getByCnpj(String cnpj) {
        return null;
    }

    public Fornecedor inativar(Long idPessoa) {
        return null;
    }

    public Fornecedor ativar(Long idPessoa) {
        return null;
    }

    public void validarCnpj(String cnpj) {
    }
}
