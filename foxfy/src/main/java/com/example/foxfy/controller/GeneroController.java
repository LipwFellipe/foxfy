package com.example.foxfy.controller;

import com.example.foxfy.model.Genero;
import com.example.foxfy.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/generos")
public class GeneroController {

    GeneroRepository generoRepository;

    @GetMapping
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genero getById(@PathVariable Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Genero save(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        generoRepository.deleteById(id);
    }
}
