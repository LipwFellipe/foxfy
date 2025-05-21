package com.example.foxfy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo_musica", nullable = false)
    private String tituloMusica;

    @Column(name = "duracao_segundos", nullable = false)
    private int duracaoSegundos;

    @Column(name = "audio", nullable = false)
    private String audio;

    @Column(name = "numero_faixa")
    private Integer numeroFaixa;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Albuns album;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
}

