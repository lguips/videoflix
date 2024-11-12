package com.videoflix.domain.category;

public record DetailCategoryDTO(Long id, String title, String color) {
    public DetailCategoryDTO(Category category) {
        this(category.getId(), category.getTitle(), category.getColor());
    }
}
