package com.forumhub.Service;

import com.forumhub.dto.TopicoDTO;
import com.forumhub.dto.TopicoDetalhesDTO;
import com.forumhub.model.Topico;
import com.forumhub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    // ✅ Método criar
    public TopicoDetalhesDTO criar(TopicoDTO dto) {
        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setDataCriacao(LocalDateTime.now()); // Adiciona a data de criação

        repository.save(topico);

        return new TopicoDetalhesDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }

    // ✅ Listar todos
    public List<TopicoDetalhesDTO> listarTodos() {
        return repository.findAll().stream()
                .map(t -> new TopicoDetalhesDTO(t.getId(), t.getTitulo(), t.getMensagem(), t.getDataCriacao()))
                .collect(Collectors.toList());
    }

    // ✅ Buscar por ID
    public TopicoDetalhesDTO buscarPorId(Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return new TopicoDetalhesDTO(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }

    // ✅ Atualizar
    public TopicoDetalhesDTO atualizar(Long id, TopicoDTO dto) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        repository.save(topico);
        return new TopicoDetalhesDTO(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }

    // ✅ Deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

