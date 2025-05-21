package com.example.foxfy.controller;

import com.example.foxfy.model.Albuns;
import com.example.foxfy.repository.AlbunsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/albuns")
public class AlbunsController {

     AlbunsRepository albumRepository;

    @GetMapping
    public List<Albuns> getAll() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Albuns getById(@PathVariable Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Albuns save(@RequestBody Albuns album) {
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumRepository.deleteById(id);
    }
}

