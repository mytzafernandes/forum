package com.forumhub.dto;

import java.time.LocalDateTime;

public record TopicoDetalhesDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {}
