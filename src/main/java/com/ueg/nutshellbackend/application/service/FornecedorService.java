package com.ueg.nutshellbackend.application.service;

import com.ueg.nutshellbackend.application.annotation.RepositoryName;
import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Contato;
import com.ueg.nutshellbackend.application.model.Endereco;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.CidadeRepository;
import com.ueg.nutshellbackend.application.repository.ContatoRepository;
import com.ueg.nutshellbackend.application.repository.FornecedorRepository;
import com.ueg.nutshellbackend.common.exception.BusinessException;
import com.ueg.nutshellbackend.common.exception.MessageCode;
import com.ueg.nutshellbackend.common.util.Util;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.jsf.FacesContextUtils;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service()
@Transactional(propagation = Propagation.REQUIRED)
@RepositoryName("FornecedorRepository")
public class FornecedorService extends AbstractService<Fornecedor, Long> {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    Set<Contato> contatos = new HashSet<>();

    @Override
    protected void prepararEdicao(Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = listarById(fornecedor.getIdPessoa());

        if(fornecedorExistente == null){
            throw new BusinessException(MessageCode.ERRO_NENHUM_REGISTRO_ENCONTRADO);
        }

        if(fornecedor.getCnpj() != null && !fornecedor.getCnpj().isBlank()){
            validarCnpj(fornecedor.getCnpj());
            validarFornecedorDuplicadoPorCnpj(fornecedor.getCnpj());
        }

        if(!fornecedorExistente.getCnpj().equals(fornecedor.getCnpj()) && fornecedor.getCnpj() == null){
            fornecedor.setCnpj(fornecedorExistente.getCnpj());
        }

        if(!fornecedorExistente.getNome().equals(fornecedor.getNome()) && fornecedor.getNome() == null){
            fornecedor.setNome(fornecedorExistente.getNome());
        }

        if(!fornecedorExistente.getNomeFantasia().equals(fornecedor.getNomeFantasia()) && fornecedor.getNomeFantasia() == null){
            fornecedor.setNomeFantasia(fornecedorExistente.getNomeFantasia());
        }

        if(!fornecedorExistente.getInscricaoEstadual().equals(fornecedor.getInscricaoEstadual()) && fornecedor.getInscricaoEstadual() == null){
            fornecedor.setInscricaoEstadual(fornecedorExistente.getInscricaoEstadual());
        }

        if(!fornecedorExistente.getInscricaoMunicipal().equals(fornecedor.getInscricaoMunicipal()) && fornecedor.getInscricaoMunicipal() == null){
            fornecedor.setInscricaoMunicipal(fornecedorExistente.getInscricaoMunicipal());
        }

        if(!fornecedorExistente.getIndicadorInscricaoEstadual().equals(fornecedor.getIndicadorInscricaoEstadual()) && fornecedor.getIndicadorInscricaoEstadual() == null){
            fornecedor.setIndicadorInscricaoEstadual(fornecedorExistente.getIndicadorInscricaoEstadual());
        }

        if(!fornecedorExistente.getContatos().equals(fornecedor.getContatos()) && fornecedor.getContatos() == null){
            fornecedor.setContatos(fornecedorExistente.getContatos());
        }

        if(!fornecedorExistente.getStatus().equals(fornecedor.getStatus()) && fornecedor.getStatus() == null){
            fornecedor.setStatus(fornecedorExistente.getStatus());
        }

        if(!fornecedorExistente.getEndereco().equals(fornecedor.getEndereco()) && fornecedor.getEndereco() == null){
            fornecedor.setEndereco(fornecedorExistente.getEndereco());
        }

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
    protected void depoisSalvar(Fornecedor fornecedor) {
        incluirContatos(fornecedor);
    }

    private void incluirContatos(Fornecedor fornecedor) {
        contatos = fornecedor.getContatos();
        for(Contato contato : contatos){
            contato.setPessoa(fornecedor);
        }
        contatoRepository.saveAll(contatos);
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

    public JasperPrint gerarRelatorio(List<Fornecedor> listaRelatorio) {
        if(listaRelatorio.isEmpty()){
            throw new BusinessException(MessageCode.ERRO_RELATORIO_VAZIO);
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("REPORT_LOCALE", new Locale("pt", "BR"));
        params.put("LOGO_PATH", ClassLoader.getSystemResource("src/main/resources/reports/assets/logoReports.png").getPath());

        List<Map<String, Object>> listaRelatorioFornecedores = new ArrayList<>();
        Endereco fornecedorEndereco = new Endereco();

        for (Fornecedor fornecedor : listaRelatorio) {
            Map<String, Object> mapParamFornecedores = new HashMap<String, Object>();
            for (Contato fornecedorContato : fornecedor.getContatos()) {
                if(fornecedorContato.getContatoPrincipal()){
                    mapParamFornecedores.put("telefonePrincipal", fornecedorContato.getTelefonePrincipal());
                    mapParamFornecedores.put("emailPrincipal", fornecedorContato.getEmail());
                }
            }
            mapParamFornecedores.put("cnpj", fornecedor.getCnpj());
            mapParamFornecedores.put("razaoSocial", fornecedor.getNome());
            fornecedorEndereco = fornecedor.getEndereco();
            if(fornecedorEndereco.getLogradouro() != null){
                mapParamFornecedores.put("endereco", fornecedorEndereco.getLogradouro());
            } else {
                mapParamFornecedores.put("endereco", "");
            }
            if(fornecedorEndereco.getCidade() != null){
                mapParamFornecedores.put("cidade",cidadeRepository.findById(fornecedorEndereco.getCidade().getId()));
            } else {
                mapParamFornecedores.put("cidade", "");
            }
            listaRelatorioFornecedores.add(mapParamFornecedores);
        }

        JRDataSource jrDataVendasPorDesconto = new JRBeanCollectionDataSource(listaRelatorioFornecedores);
        String baseReportPath = "fornecedorReport.jasper";

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(baseReportPath, params, jrDataVendasPorDesconto);
            return jasperPrint;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
