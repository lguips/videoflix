package com.videoflix.domain.category;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryDTO(
        @NotBlank
        String title,

        @NotBlank
        String color
) {
}
