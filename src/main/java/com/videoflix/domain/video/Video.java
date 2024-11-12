package com.videoflix.domain.video;

import com.videoflix.domain.UpdateVideoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public Video(CreateVideoDTO data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.url = data.url();
    }

    public void update(UpdateVideoDTO data) {
        if (data.titulo() != null) {
            this.titulo = data.titulo();
        }

        if (data.descricao() != null) {
            this.descricao = data.descricao();
        }

        if (data.url() != null) {
            this.url = data.url();
        }
    }
}
