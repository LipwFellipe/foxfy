package com.example.foxfy.controller;

import com.example.foxfy.dto.MusicaDTO;
import com.example.foxfy.model.Albuns;
import com.example.foxfy.model.Genero;
import com.example.foxfy.model.Musica;
import com.example.foxfy.repository.AlbunsRepository;
import com.example.foxfy.repository.GeneroRepository;
import com.example.foxfy.repository.MusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/musicas")
public class MusicaController {

    MusicaRepository musicaRepository;
    AlbunsRepository albunsRepository;
    GeneroRepository generoRepository;

    @GetMapping
    public List<Musica> getAll() {
        return musicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Musica getById(@PathVariable Long id) {
        return musicaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Musica save(@RequestBody MusicaDTO musicaDTO) {
        Albuns album = albunsRepository.findById(musicaDTO.getAlbum())
                .orElseThrow(() -> new RuntimeException("Álbum não encontrado com id: " + musicaDTO.getAlbum()));

        Genero genero = generoRepository.findById(musicaDTO.getGenero())
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado com id: " + musicaDTO.getGenero()));

        Musica musica = new Musica();
        musica.setTituloMusica(musicaDTO.getTituloMusica());
        musica.setDuracaoSegundos(musicaDTO.getDuracaoSegundos());
        musica.setAudio(musicaDTO.getAudio());
        musica.setAlbum(album);
        musica.setGenero(genero);

        return musicaRepository.save(musica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        musicaRepository.deleteById(id);
    }
}
