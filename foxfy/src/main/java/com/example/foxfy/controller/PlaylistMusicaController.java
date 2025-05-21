package com.example.foxfy.controller;

import com.example.foxfy.model.PlaylistMusica;
import com.example.foxfy.repository.PlaylistMusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/playlist-musicas")
public class PlaylistMusicaController {

    PlaylistMusicaRepository playlistMusicaRepository;

    @GetMapping
    public List<PlaylistMusica> getAll() {
        return playlistMusicaRepository.findAll();
    }

    @PostMapping
    public PlaylistMusica save(@RequestBody PlaylistMusica item) {
        return playlistMusicaRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistMusicaRepository.deleteById(id);
    }
}
