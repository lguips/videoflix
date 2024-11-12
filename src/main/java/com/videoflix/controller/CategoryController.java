package com.videoflix.controller;

import com.videoflix.domain.category.Category;
import com.videoflix.domain.category.CategoryRepository;
import com.videoflix.domain.category.CreateCategoryDTO;
import com.videoflix.domain.category.DetailCategoryDTO;
import com.videoflix.domain.video.CreateVideoDTO;
import com.videoflix.domain.video.DetailVideoDTO;
import com.videoflix.domain.video.Video;
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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailCategoryDTO> create(@RequestBody @Valid CreateCategoryDTO data, UriComponentsBuilder uriBuilder) {
        var category = new Category(data);
        repository.save(category);
        var uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailCategoryDTO(category));
    }
}
