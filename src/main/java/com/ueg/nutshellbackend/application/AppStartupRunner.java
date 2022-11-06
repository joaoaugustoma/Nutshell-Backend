package com.ueg.nutshellbackend.application;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.repository.fornecedor.FornecedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;


    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Application started with option names : {}",
                args.getOptionNames());
        LOG.info("spring.jpa.hibernate.ddl-auto={}",ddlAuto);

        initiateDemoInstance();
    }

    private void initiateDemoInstance() {
        fornecedorInstance();
    }

    private void fornecedorInstance() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdPessoa(1L);
        fornecedor.setNome("SAFEWARE TECNOLOGIA LTDA");
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setEnderecos(new HashSet<>());
        fornecedor.setCnpj("08103165000109");
        fornecedor.setInscricaoEstadual("388.108.598.269");
        fornecedor.setNomeFantasia("UNIKA SISTEMAS");
        fornecedor.setDataCadastro(LocalDate.of(2021, 10, 19));
        fornecedor.setDataAtualizacao(LocalDate.now());
        fornecedor.setContatos(new HashSet<>());
        fornecedor.setInscricaoMunicipal("388.108.598.269");
        fornecedor.setIndicadorInscricaoEstadual(IndicadorInscricaoEstadual.CONTRIBUINTE);

        fornecedorRepository.save(fornecedor);

        fornecedor.setIdPessoa(2L);
        fornecedor.setNome("uau");
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setEnderecos(new HashSet<>());
        fornecedor.setCnpj("00000000000001");
        fornecedor.setInscricaoEstadual("123.123.123.123");
        fornecedor.setNomeFantasia("UNIKA");
        fornecedor.setDataCadastro(LocalDate.of(2021, 10, 24));
        fornecedor.setDataAtualizacao(LocalDate.now());
        fornecedor.setContatos(new HashSet<>());

        fornecedorRepository.save(fornecedor);

    }
}
