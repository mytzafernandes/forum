

package com.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem
) {}

