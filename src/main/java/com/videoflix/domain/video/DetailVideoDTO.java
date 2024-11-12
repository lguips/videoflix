package com.videoflix.domain.video;

public record DetailVideoDTO(Long id, String titulo, String descricao, String url) {
    public DetailVideoDTO(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
