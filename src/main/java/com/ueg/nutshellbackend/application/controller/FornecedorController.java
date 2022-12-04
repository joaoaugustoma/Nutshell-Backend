package com.ueg.nutshellbackend.application.controller;

import com.ueg.nutshellbackend.application.dto.FornecedorDTO;
import com.ueg.nutshellbackend.application.mapper.FornecedorMapper;
import com.ueg.nutshellbackend.application.model.Fornecedor;
import com.ueg.nutshellbackend.application.service.FornecedorService;
import com.ueg.nutshellbackend.common.exception.NotFoundException;
import org.slf4j.Logger;
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

    @Autowired
    private Logger log;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> incluir(@RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor = fornecedorService.salvar(fornecedor);
        fornecedorDTO = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    @PutMapping(path = "/{idPessoa}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> alterar(@PathVariable final Long idPessoa, @RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor.setIdPessoa(idPessoa);
        fornecedorService.salvar(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarTudo();
        List<FornecedorDTO> fornecedoresDTO = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            fornecedoresDTO.add(fornecedorMapper.toDTO(fornecedor));
        }
        return ResponseEntity.ok(fornecedoresDTO);
    }

    @GetMapping(path = "{idPessoa}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getFornecedorById(@PathVariable("idPessoa") Long idPessoa) {
        Fornecedor fornecedor = new Fornecedor();
        try {
            fornecedor = fornecedorService.listarById(idPessoa);
        } catch (NotFoundException e) {
            log.error("Fornecedor não encontrado");
        }
        FornecedorDTO fornecedorDTO = new FornecedorDTO();

        if (fornecedor != null)
            fornecedorDTO = fornecedorMapper.toDTO(fornecedor);
        return ResponseEntity.ok(fornecedorDTO);
    }


    @GetMapping(path = "/filtro", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getFornecedorsByFiltro(@ModelAttribute("filtroDTO") final FornecedorDTO filtroDTO) {
        List<Fornecedor> fornecedores = fornecedorService.listarByFiltro(filtroDTO);
        List<FornecedorDTO> fornecedoresDTO = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            fornecedoresDTO.add(fornecedorMapper.toDTO(fornecedor));
        }
        return ResponseEntity.ok(fornecedoresDTO);
    }

    @PatchMapping(path = "/{idPessoa:\\d}/inativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> inativar(@PathVariable final Long idPessoa) {
        fornecedorService.inativar(idPessoa);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{idPessoa:\\d}/ativo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ativar(@PathVariable final Long idPessoa) {
        fornecedorService.ativar(idPessoa);
        return ResponseEntity.ok().build();
    }
}
