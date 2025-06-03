package com.example.foxfy.controller;

import com.example.foxfy.dto.MembrosMusicasDTO;
import com.example.foxfy.model.Membros;
import com.example.foxfy.model.MembrosMusicas;
import com.example.foxfy.model.Musica;
import com.example.foxfy.repository.MembroRepository;
import com.example.foxfy.repository.MembrosMusicasRepository;
import com.example.foxfy.repository.MusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/membros-musicas")
public class MembrosMusicasController {

    MembrosMusicasRepository membrosMusicasRepository;
    MusicaRepository musicaRepository;
    MembroRepository membrosRepository;

    @GetMapping
    public List<MembrosMusicas> getAll() {
        return membrosMusicasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembrosMusicas> getById(@PathVariable Long id) {
        return membrosMusicasRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MembrosMusicasDTO dto) {
        // Validação de existência
        Musica musica = musicaRepository.findById(dto.getMusicaId()).orElse(null);
        Membros membro = membrosRepository.findById(dto.getMembroId()).orElse(null);

        if (musica == null || membro == null) {
            return ResponseEntity.badRequest().body("Musica ou Membro não encontrados.");
        }

        // Validação para evitar duplicação
        boolean exists = membrosMusicasRepository.findAll().stream()
                .anyMatch(m -> m.getMusica().getId().equals(dto.getMusicaId()) &&
                        m.getMembro().getId().equals(dto.getMembroId()));

        if (exists) {
            return ResponseEntity.badRequest().body("Associação já existe.");
        }

        MembrosMusicas novo = new MembrosMusicas();
        novo.setMusica(musica);
        novo.setMembro(membro);

        return ResponseEntity.ok(membrosMusicasRepository.save(novo));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        membrosMusicasRepository.deleteById(id);
    }
}

