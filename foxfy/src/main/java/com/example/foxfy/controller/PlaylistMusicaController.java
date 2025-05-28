package com.example.foxfy.controller;

import com.example.foxfy.dto.PlaylistMusicaDTO;
import com.example.foxfy.model.Musica;
import com.example.foxfy.model.Playlist;
import com.example.foxfy.model.PlaylistMusica;
import com.example.foxfy.repository.PlaylistMusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/playlist-musicas")
public class PlaylistMusicaController {

    PlaylistMusicaRepository playlistMusicaRepository;

    @GetMapping
    public List<PlaylistMusica> getAll() {
        return playlistMusicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistMusica> getById(@PathVariable Long id) {
        Optional<PlaylistMusica> playlistMusica = playlistMusicaRepository.findById(id);

        return playlistMusica
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlaylistMusica save(@RequestBody PlaylistMusicaDTO dto) {
        Playlist playlist = new Playlist();
        playlist.setId(dto.getPlaylistId());

        Musica musica = new Musica();
        musica.setId(dto.getMusicaId());

        PlaylistMusica item = new PlaylistMusica();
        item.setPlaylist(playlist);
        item.setMusica(musica);
        item.setDataAdicao(LocalDateTime.now()); // Define o horário da criação

        return playlistMusicaRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistMusicaRepository.deleteById(id);
    }
}
