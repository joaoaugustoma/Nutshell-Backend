package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service()
@Transactional(propagation = Propagation.REQUIRED)
public class FornecedorService extends AbstractService<Fornecedor, FornecedorDTO, Long> {
    @Autowired
    private FornecedorRepository fornecedorRepository;

//    @Override
//    public List<Fornecedor> listarByFiltro(FornecedorDTO tabela) {
//        return null;
//    }

    @Override
    protected JpaRepository<Fornecedor, Long> getRepository() {
        return  this.fornecedorRepository;
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
        validarFornecedorDuplicadoPorCnpj(fornecedor);

        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setDataCadastro(LocalDate.now());
        fornecedor.setDataAtualizacao(LocalDate.now());
    }

    @Override
    public void validarCamposObrigatorios(Fornecedor fornecedor) {
        //TODO implementar validação de campos obrigatorios
    }

    public void validarFornecedorDuplicadoPorCnpj(Fornecedor fornecedor) {
        //TODO implementar validação de cnpj duplicado
    }

    public Fornecedor inativar(Long idPessoa) {
        //TODO inativar fornecedor
        return null;
    }

    public Fornecedor ativar(Long idPessoa) {
        //TODO ativar fornecedor
        return null;
    }

    public void validarCnpj(String cnpj) {
    }
}
