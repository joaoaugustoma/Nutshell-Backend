package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FornecedorService extends AbstractService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    public void setFornecedorRepository(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository=fornecedorRepository;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        validarCamposObrigatorios(fornecedor);
        validarFornecedorDuplicadoPorCnpj(fornecedor);


        if (fornecedor.getIdPessoa() == null) {

            fornecedor.setStatus(StatusAtivoInativo.ATIVO);
            LocalDate data = LocalDate.now();
            fornecedor.setDataCadastro(data);
            fornecedor.setDataAtualizacao(data);

        } else {
            Fornecedor fornecedorExistente = getByIdPessoa(fornecedor.getIdPessoa());

            fornecedor.setStatus(fornecedorExistente.getStatus());
            fornecedor.setDataCadastro(fornecedorExistente.getDataCadastro());
            fornecedor.setDataAtualizacao(LocalDate.now());
        }

        fornecedor = fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    public List<Fornecedor> getAll() {
        return null;
    }

    public Fornecedor getByIdPessoa(Long idPessoa) {
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

    @Override
    public Boolean validarCamposObrigatorios(Object object) {
        return null;
    }

    @Override
    public Boolean validarFornecedorDuplicadoPorCnpj(Object object) {
        return null;
    }
}
