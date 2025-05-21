package com.example.foxfy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Albuns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo_album", nullable = false)
    private String tituloAlbum;

    @Column(name = "data_lancamento")
    private LocalDateTime dataLancamento = LocalDateTime.now();

    @Column(name = "foto")
    private String foto;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Musica> musicas;


}
