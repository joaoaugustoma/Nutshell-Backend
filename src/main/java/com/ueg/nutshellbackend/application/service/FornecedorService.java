package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.FornecedorRepository;
import com.ueg.nutshellbackend.common.exception.BusinessException;
import com.ueg.nutshellbackend.common.exception.MessageCode;
import com.ueg.nutshellbackend.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service()
@Transactional(propagation = Propagation.REQUIRED)
public class FornecedorService extends AbstractService<Fornecedor, FornecedorDTO, Long> {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    protected JpaRepository<Fornecedor, Long> getRepository() {
        return  this.fornecedorRepository;
    }

    @Override
    protected void prepararEdicao(Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = listarById(fornecedor.getIdPessoa());

        validarCnpj(fornecedor.getCnpj());
        validarFornecedorDuplicadoPorCnpj(fornecedor.getCnpj());

        fornecedor.setStatus(fornecedorExistente.getStatus());
        fornecedor.setDataCadastro(fornecedorExistente.getDataCadastro());
        fornecedor.setDataAtualizacao(LocalDate.now());
    }

    @Override
    protected void prepararInclusao(Fornecedor fornecedor) {
        validarCnpj(fornecedor.getCnpj());
        validarFornecedorDuplicadoPorCnpj(fornecedor.getCnpj());

        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setDataCadastro(LocalDate.now());
        fornecedor.setDataAtualizacao(LocalDate.now());
    }

    @Override
    public void validarCamposObrigatorios(Fornecedor fornecedor) {
        //TODO implementar validação de campos obrigatorios
    }


    public Fornecedor inativar(Long idPessoa) {
        Fornecedor fornecedor = fornecedorRepository.getReferenceById(idPessoa);
        fornecedor.setStatus(StatusAtivoInativo.INATIVO);

        return fornecedor;
    }

    public Fornecedor ativar(Long idPessoa) {
        Fornecedor fornecedor = fornecedorRepository.getReferenceById(idPessoa);
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);

        return fornecedor;
    }

    private void validarFornecedorDuplicadoPorCnpj(String cnpj) {
        Fornecedor fornecedorByCnpj = fornecedorRepository.findByCnpj(cnpj);
        Long count = fornecedorRepository.countByCnpj(cnpj);

        if ( (count > BigDecimal.ONE.longValue() && fornecedorByCnpj.getIdPessoa()!=null) ||
                (count > BigDecimal.ZERO.longValue() && fornecedorByCnpj.getIdPessoa()==null)
        ) {
            throw new BusinessException(MessageCode.ERRO_CNPJ_EM_USO);
        }
    }

    private void validarCnpj(String cnpj) {
        if (!Util.isCnpjValido(cnpj)) {
            throw new BusinessException(MessageCode.ERRO_CNPJ_INVALIDO);
        }
    }

    public List<Fornecedor> listarByFiltro(FornecedorDTO filtroDTO) {
        return fornecedorRepository.listarByFiltro(filtroDTO);
    }
}
