package com.example.foxfy.dto;

import lombok.Data;

@Data
public class MusicaDTO {
    private String tituloMusica;
    private int duracaoSegundos;
    private String audio;
    private Integer numeroFaixa;
    private Long album; // apenas o ID
    private Long genero; // apenas o ID

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Integer getNumeroFaixa() {
        return numeroFaixa;
    }

    public void setNumeroFaixa(Integer numeroFaixa) {
        this.numeroFaixa = numeroFaixa;
    }

    public Long getAlbum() {
        return album;
    }

    public void setAlbum(Long album) {
        this.album = album;
    }

    public Long getGenero() {
        return genero;
    }

    public void setGenero(Long genero) {
        this.genero = genero;
    }
}
