package com.videoflix.controller;

import com.videoflix.domain.UpdateVideoDTO;
import com.videoflix.domain.video.CreateVideoDTO;
import com.videoflix.domain.video.DetailVideoDTO;
import com.videoflix.domain.video.Video;
import com.videoflix.domain.video.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailVideoDTO> create(@RequestBody @Valid CreateVideoDTO data, UriComponentsBuilder uriBuilder) {
        var video = new Video(data);
        repository.save(video);
        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailVideoDTO(video));
    }

    @GetMapping
    public ResponseEntity<Page<DetailVideoDTO>> findAll(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(DetailVideoDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailVideoDTO> detail(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetailVideoDTO(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailVideoDTO> atualizar(@RequestBody @Valid UpdateVideoDTO data) {
        var video = repository.getReferenceById(data.id());
        video.update(data);
        return ResponseEntity.ok(new DetailVideoDTO(video));
    }
}
