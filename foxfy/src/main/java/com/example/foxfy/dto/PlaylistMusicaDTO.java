package com.example.foxfy.dto;

import lombok.Data;

@Data
public class PlaylistMusicaDTO {
    private Long playlistId;
    private Long musicaId;

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(Long musicaId) {
        this.musicaId = musicaId;
    }
}