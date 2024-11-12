package com.videoflix.domain.category;

import com.videoflix.domain.video.UpdateVideoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categories")
@Entity(name = "Category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String color;

    public Category(CreateCategoryDTO data) {
        this.title = data.title();
        this.color = data.color();
    }

    public void update(UpdateCategoryDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.color() != null) {
            this.color = data.color();
        }
    }
}
