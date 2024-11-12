package com.videoflix.controller;

import com.videoflix.domain.category.*;
import com.videoflix.domain.video.DetailVideoDTO;
import com.videoflix.domain.video.UpdateVideoDTO;
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

    @GetMapping
    public ResponseEntity<Page<DetailCategoryDTO>> findAll(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(DetailCategoryDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailCategoryDTO> detail(@PathVariable Long id) {
        var category = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetailCategoryDTO(category));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailCategoryDTO> update(@RequestBody @Valid UpdateCategoryDTO data) {
        var category = repository.getReferenceById(data.id());
        category.update(data);
        return ResponseEntity.ok(new DetailCategoryDTO(category));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
