package com.videoflix.domain.video;

import jakarta.validation.constraints.NotBlank;

public record CreateVideoDTO(
        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotBlank
        String url
) {
}
