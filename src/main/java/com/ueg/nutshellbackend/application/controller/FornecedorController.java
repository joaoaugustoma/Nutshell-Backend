package com.ueg.nutshellbackend.application.controller;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.mapper.FornecedorMapper;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${app.api.base}/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> incluir(@RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor = fornecedorService.salvar(fornecedor);
        fornecedorDTO = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    @PutMapping(path = "/{idPessoa:[\\d]+}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> alterar(@PathVariable final Long idPessoa, @RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor.setIdPessoa(idPessoa);
        fornecedorService.salvar(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getFornecedores(){
        List<Fornecedor> fornecedores = fornecedorService.getAll();
        List<FornecedorDTO> fornecedoresDTO = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            FornecedorDTO fornecedorDTO = fornecedorMapper.toDTO(fornecedor);
            fornecedoresDTO.add(fornecedorDTO);
        }
        return ResponseEntity.ok(fornecedoresDTO);
    }

    @GetMapping( path = "{idPessoa}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getFornecedorById(@PathVariable("idPessoa") Long idPessoa) {
        Fornecedor fornecedor = fornecedorService.getByIdPessoa(idPessoa);
        FornecedorDTO fornecedorDTO = new FornecedorDTO();

        if(fornecedor != null)
            fornecedorDTO = fornecedorMapper.toDTO(fornecedor);

        return ResponseEntity.ok(fornecedorDTO);
    }

    @GetMapping( path = "{cnpj}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getByCnpj(@PathVariable("cnpj") String cnpj) {
        Fornecedor fornecedor = fornecedorService.getByCnpj(cnpj);
        FornecedorDTO fornecedorDTO = new FornecedorDTO();

        if(fornecedor != null)
            fornecedorDTO = fornecedorMapper.toDTO(fornecedor);

        return ResponseEntity.ok(fornecedorDTO);
    }
//    TODO
//    @GetMapping(path = "/filtro", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public ResponseEntity<?> getFornecedorsByFiltro(@ModelAttribute("filtroDTO") final FiltroFornecedorDTO filtroDTO) {
//        List<Fornecedor> fornecedores = fornecedorService.getFornecedoresByFiltro(filtroDTO);
//        List<FornecedorDTO> fornecedoresDTO = new ArrayList<>();
//        for (Fornecedor fornecedor: fornecedores) {
//            fornecedoresDTO.add (fornecedorMapper.toDTO(fornecedor));
//        }
//
//        return ResponseEntity.ok(fornecedoresDTO);
//    }

    @PutMapping(path = "/{idPessoa:[\\d]+}/inativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> inativar(@PathVariable final Long idPessoa) {
        fornecedorService.inativar(idPessoa);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{idPessoa:[\\d]+}/ativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ativar(@PathVariable final Long idPessoa) {
        fornecedorService.ativar(idPessoa);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "cnpj/valido/{cnpj}")
    public ResponseEntity<?> validarCpfCnpj(@PathVariable final String cnpj) {
        fornecedorService.validarCnpj(cnpj);
        return ResponseEntity.ok().build();
    }
}