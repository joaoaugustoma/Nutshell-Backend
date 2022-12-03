package com.ueg.nutshellbackend.application;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Cidade;
import com.ueg.nutshellbackend.application.model.Endereco;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.CidadeRepository;
import com.ueg.nutshellbackend.application.repository.FornecedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initiateDemoInstance();
    }

    private void initiateDemoInstance() {
        fornecedorInstance();
    }

    private void fornecedorInstance() {
        Endereco endereco = enderecoInstance();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdPessoa(1L);
        fornecedor.setNome("SAFEWARE TECNOLOGIA LTDA");
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setEnderecos(Collections.singleton(endereco));
        fornecedor.setCnpj("08103165000109");
        fornecedor.setInscricaoEstadual("388.108.598.269");
        fornecedor.setNomeFantasia("UNIKA SISTEMAS");
        fornecedor.setDataCadastro(LocalDate.of(2021, 10, 19));
        fornecedor.setDataAtualizacao(LocalDate.now());
        fornecedor.setContatos(new HashSet<>());
        fornecedor.setInscricaoMunicipal("388.108.598.269");
        fornecedor.setIndicadorInscricaoEstadual(IndicadorInscricaoEstadual.CONTRIBUINTE);

        fornecedorRepository.save(fornecedor);

        endereco.setId(2L);

        fornecedor.setIdPessoa(2L);
        fornecedor.setNome("uau");
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setEnderecos(Collections.singleton(endereco));
        fornecedor.setCnpj("00000000000001");
        fornecedor.setInscricaoEstadual("123.123.123.123");
        fornecedor.setNomeFantasia("UNIKA");
        fornecedor.setDataCadastro(LocalDate.of(2021, 10, 24));
        fornecedor.setDataAtualizacao(LocalDate.now());
        fornecedor.setContatos(new HashSet<>());

        fornecedorRepository.save(fornecedor);

    }

    private Endereco enderecoInstance(){
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setBairro("Setor Central");
        endereco.setNumeroEndereco("1440");
        endereco.setCep("75020010");
        endereco.setLogradouro("Avenidade Contorno");
        endereco.setComplemento("Sala 501");
        endereco.setCidade(cidadeInstance());

        return endereco;
    }
    private Cidade cidadeInstance(){
        return cidadeRepository.getReferenceById(2007L);
    }
}
