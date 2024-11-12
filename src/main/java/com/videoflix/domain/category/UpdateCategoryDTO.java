package com.videoflix.domain.category;

import jakarta.validation.constraints.NotNull;

public record UpdateCategoryDTO(
        @NotNull
        Long id,
        String title,
        String color) {
}
