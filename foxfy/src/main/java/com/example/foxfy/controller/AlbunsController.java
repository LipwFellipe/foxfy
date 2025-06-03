package com.example.foxfy.controller;

import com.example.foxfy.model.Albuns;
import com.example.foxfy.repository.AlbunsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/albuns")
public class AlbunsController {

     AlbunsRepository albumRepository;

    @GetMapping
    @Transactional
    public List<Albuns> getAll() {
        return albumRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Albuns> buscarPorId(@PathVariable Long id) {
        return albumRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Albuns> save(@RequestBody Albuns album) {
        Albuns salvo = albumRepository.save(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlbum(@PathVariable Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

