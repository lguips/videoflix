package com.videoflix.controller;

import com.videoflix.domain.video.CreateVideoDTO;
import com.videoflix.domain.video.DetailVideoDTO;
import com.videoflix.domain.video.Video;
import com.videoflix.domain.video.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailVideoDTO> create(@RequestBody @Valid CreateVideoDTO dados, UriComponentsBuilder uriBuilder) {
        var video = new Video(dados);
        repository.save(video);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailVideoDTO(video));
    }
}
