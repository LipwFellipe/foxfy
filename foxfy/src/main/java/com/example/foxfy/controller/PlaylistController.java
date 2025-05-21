package com.example.foxfy.controller;

import com.example.foxfy.model.Playlist;
import com.example.foxfy.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {

    PlaylistRepository playlistRepository;

    @GetMapping
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getById(@PathVariable Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Playlist save(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistRepository.deleteById(id);
    }
}
