package com.example.foxfy.dto;

import lombok.Data;

@Data
public class MembrosMusicasDTO {
    private Long musicaId;
    private Long membroId;

    public Long getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(Long musicaId) {
        this.musicaId = musicaId;
    }

    public Long getMembroId() {
        return membroId;
    }

    public void setMembroId(Long membroId) {
        this.membroId = membroId;
    }
}
