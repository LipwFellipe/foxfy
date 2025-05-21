package com.example.foxfy.controller;

import com.example.foxfy.model.Membros;
import com.example.foxfy.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/membros")
@AllArgsConstructor
public class MembroController {

    MembroRepository membroRepository;

    @GetMapping
    public List<Membros> listarMembros() {
        return membroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Membros buscarPorId(@PathVariable Long id) {
        return membroRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Membros criarMembro(@RequestBody Membros membro) {
        return membroRepository.save(membro);
    }

    @DeleteMapping("/{id}")
    public void deletarMembro(@PathVariable Long id) {
        membroRepository.deleteById(id);
    }
}
