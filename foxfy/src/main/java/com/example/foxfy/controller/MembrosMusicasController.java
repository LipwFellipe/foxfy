package com.example.foxfy.controller;

import com.example.foxfy.model.MembrosMusicas;
import com.example.foxfy.repository.MembrosMusicasRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/membros-musicas")
public class MembrosMusicasController {

    MembrosMusicasRepository membrosMusicasRepository;

    @GetMapping
    public List<MembrosMusicas> getAll() {
        return membrosMusicasRepository.findAll();
    }

    @PostMapping
    public MembrosMusicas save(@RequestBody MembrosMusicas item) {
        return membrosMusicasRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        membrosMusicasRepository.deleteById(id);
    }
}

