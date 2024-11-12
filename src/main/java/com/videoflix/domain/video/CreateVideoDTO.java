package com.videoflix.domain.video;

import jakarta.validation.constraints.NotBlank;

public record CreateVideoDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        String url
) {
}
