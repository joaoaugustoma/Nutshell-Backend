package com.ueg.nutshellbackend.application;

import com.ueg.nutshellbackend.application.enums.IndicadorInscricaoEstadual;
import com.ueg.nutshellbackend.application.enums.StatusAtivoInativo;
import com.ueg.nutshellbackend.application.enums.TipoTelefone;
import com.ueg.nutshellbackend.application.model.*;
import com.ueg.nutshellbackend.application.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
     initiateDemoInstance();
    }

    private void initiateDemoInstance() {
       fornecedorInstance();
    }

    private void fornecedorInstance() {
        Endereco endereco = enderecoInstance();
        Contato contato = contatoInstance();
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome("SAFEWARE TECNOLOGIA LTDA");
        fornecedor.setStatus(StatusAtivoInativo.ATIVO);
        fornecedor.setEndereco(endereco);
        fornecedor.setCnpj("08103165000109");
        fornecedor.setInscricaoEstadual("388.108.598.269");
        fornecedor.setNomeFantasia("UNIKA SISTEMAS");
        fornecedor.setDataCadastro(LocalDate.of(2021, 10, 19));
        fornecedor.setDataAtualizacao(LocalDate.now());
        fornecedor.setContatos(Collections.singleton(contato));
        fornecedor.setInscricaoMunicipal("388.108.598.269");
        fornecedor.setIndicadorInscricaoEstadual(IndicadorInscricaoEstadual.CONTRIBUINTE);

        fornecedorRepository.save(fornecedor);

        contato.setPessoa(fornecedor);
        contatoRepository.save(contato);
    }

    private Contato contatoInstance() {
        Contato contato = new Contato();
        contato.setNome("João");
        contato.setEmail("joao@email.com");
        contato.setDdd("61");
        contato.setTelefone("999999999");

        return contato;
    }

//    private Telefone telefoneInstance() {
//        Telefone telefone = new Telefone();
//        telefone.setDdd("61");
//        telefone.setNumero("999999999");
//        telefone.setTipo(TipoTelefone.CELULAR);
//
//        return telefone;
//    }

    private Endereco enderecoInstance(){
        Endereco endereco = new Endereco();
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
