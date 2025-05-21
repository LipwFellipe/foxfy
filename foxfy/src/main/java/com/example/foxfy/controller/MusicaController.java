package com.example.foxfy.controller;

import com.example.foxfy.model.Musica;
import com.example.foxfy.repository.MusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/musicas")
public class MusicaController {

    MusicaRepository musicaRepository;

    @GetMapping
    public List<Musica> getAll() {
        return musicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Musica getById(@PathVariable Long id) {
        return musicaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Musica save(@RequestBody Musica musica) {
        return musicaRepository.save(musica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicaRepository.deleteById(id);
    }
}
