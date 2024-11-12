package com.videoflix.domain.video;

public record DetailVideoDTO(Long id, String title, String description, String url) {
    public DetailVideoDTO(Video video) {
        this(video.getId(), video.getTitle(), video.getDescription(), video.getUrl());
    }
}
