

package com.forumhub.controller;

import com.forumhub.dto.TopicoDTO;
import com.forumhub.dto.TopicoDetalhesDTO;
import com.forumhub.Service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TopicoDetalhesDTO> criar(@RequestBody @Valid TopicoDTO dto) {
        TopicoDetalhesDTO topico = service.criar(dto);
        return ResponseEntity.created(URI.create("/topicos/" + topico.id())).body(topico);
    }

    @GetMapping
    public ResponseEntity<List<TopicoDetalhesDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalhesDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDetalhesDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
