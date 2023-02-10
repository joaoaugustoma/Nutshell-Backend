package com.ueg.nutshellbackend.application.controller;

import com.ueg.nutshellbackend.application.dto.ContatoDTO;
import com.ueg.nutshellbackend.application.mapper.ContatoMapper;
import com.ueg.nutshellbackend.application.model.Contato;
import com.ueg.nutshellbackend.application.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${app.api.base}/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ContatoMapper contatoMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> incluir(@RequestBody ContatoDTO contatoDTO) {
        Contato contato = contatoMapper.toEntity(contatoDTO);

        contato = contatoService.salvar(contato);
        contatoDTO = contatoMapper.toDTO(contato);
        return ResponseEntity.ok(contatoDTO);
    }

    @PutMapping(path = "/{idContato}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> alterar(@PathVariable final Long idContato, @RequestBody ContatoDTO contatoDTO) {
        Contato contato = contatoMapper.toEntity(contatoDTO);
        contato.setIdContato(idContato);
        contatoService.salvar(contato);
        return ResponseEntity.ok(contatoDTO);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getContatos() {
        List<Contato> contatos = contatoService.listarTudo();
        List<ContatoDTO> contatosDTO = new ArrayList<>();
        for (Contato contato : contatos) {
            contatosDTO.add(contatoMapper.toDTO(contato));
        }
        return ResponseEntity.ok(contatosDTO);
    }

    @DeleteMapping(path = "/{idContato}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> excluir(@PathVariable final Long idContato) {
        contatoService.excluir(idContato);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path ="/fav/{idContato}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> favoritar(@PathVariable final Long idContato) {
        Contato contato = contatoService.listarById(idContato);
        contato.setFav(!contato.isFav());
        contatoService.salvar(contato);
        return ResponseEntity.ok().build();
    }
}
