package com.videoflix.domain.video;

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

    public Video(@Valid CreateVideoDTO dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
    }
}
