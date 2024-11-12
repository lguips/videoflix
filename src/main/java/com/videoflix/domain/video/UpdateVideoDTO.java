package com.videoflix.domain.video;

import jakarta.validation.constraints.NotNull;

public record UpdateVideoDTO(
        @NotNull
        Long id,
        String title,
        String description,
        String url
) {
}
