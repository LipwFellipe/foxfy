# 🎵 Projeto JAVA APIS - FOXFY
(Este é um projeto academico)
Link do front end [aqui](https://github.com/LipwFellipe/FrontFoxfy)


Bem-vindo ao FOXFY, o verdadeiro criador de playlists!
Este projeto é um clone (com muito mais personalidade) do famoso Spotify. Desenvolvemos esta aplicação back-end em Java
Utilizando boas práticas de API REST, utilizando JPA para persistência de dados e conexão com SQL Server.

# 🧰 Tecnologias Utilizadas
- Java
- Spring Boot
- JPA (Java Persistence API)
- SQL Server
- Docker (recomendado para o banco de dados)
- Padrões MVC (Model, Controller, Repository, DTO)

# 🚀 Como Rodar o Projeto
Suba um container Docker com SQL Server.
Você pode usar o Docker compose que disponibilizamos e depois apenas atualize a string de conexão no arquivo application.properties ou application.yml com as credenciais do seu banco SQL Server:

🗂 Estrutura do Projeto
O projeto está organizado em pacotes seguindo o padrão MVC:

model: entidades JPA que representam as tabelas no banco de dados.

repository: interfaces que extendem JpaRepository para manipulação dos dados.

controller: classes responsáveis por expor as rotas da API.

dto: objetos usados para transferir dados entre as camadas da aplicação.
