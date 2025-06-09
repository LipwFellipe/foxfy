CREATE TABLE genero (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE album (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo_album VARCHAR(255) NOT NULL,
    data_lancamento DATETIME DEFAULT CURRENT_TIMESTAMP,
    foto VARCHAR(500),
    PRIMARY KEY (id)
);

CREATE TABLE musica (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo_musica VARCHAR(255) NOT NULL,
    duracao_segundos INT NOT NULL,
    audio VARCHAR(500) NOT NULL,
    album_id BIGINT,
    genero_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (album_id) REFERENCES album(id),
    FOREIGN KEY (genero_id) REFERENCES genero(id)
);

CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    foto VARCHAR(500),
    PRIMARY KEY (id)
);

CREATE TABLE playlist (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_playlist VARCHAR(255) NOT NULL,
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    foto VARCHAR(500),
    usuario_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE playlist_musica (
    id BIGINT NOT NULL AUTO_INCREMENT,
    playlist_id BIGINT NOT NULL,
    musica_id BIGINT NOT NULL,
    data_adicao DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id),
    FOREIGN KEY (musica_id) REFERENCES musica(id),
    UNIQUE (playlist_id, musica_id)
);

CREATE TABLE membro (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descr TEXT,
    foto VARCHAR(500),
    tipo VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE membros_musicas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    musica_id BIGINT NOT NULL,
    membro_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (musica_id) REFERENCES musica(id),
    FOREIGN KEY (membro_id) REFERENCES membro(id),
    UNIQUE (musica_id, id)
);
