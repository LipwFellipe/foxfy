package com.example.foxfy.controller;

import com.example.foxfy.dto.PlaylistDTO;
import com.example.foxfy.model.Playlist;
import com.example.foxfy.model.Usuario;
import com.example.foxfy.repository.PlaylistRepository;
import com.example.foxfy.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {

    PlaylistRepository playlistRepository;
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getById(@PathVariable Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Playlist save(@RequestBody PlaylistDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Playlist playlist = new Playlist();
        playlist.setNomePlaylist(dto.getNomePlaylist());
        playlist.setFoto(dto.getFoto());
        playlist.setUsuario(usuario);

        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playlistRepository.deleteById(id);
    }
}
