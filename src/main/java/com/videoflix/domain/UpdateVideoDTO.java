package com.videoflix.domain;

import jakarta.validation.constraints.NotNull;

public record UpdateVideoDTO(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String url
) {
}
