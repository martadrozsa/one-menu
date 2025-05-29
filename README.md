# one-menu

Projeto desenvolvido em Java com Spring Boot para gerenciamento de usuários e autenticação.

## Requisitos

- Java 21
- Gradle
- Banco de dados MySQL
- Postman (opcional, para testes de API)
- Docker (opcional, para rodar o banco de dados)


## Como rodar o projeto

1. Clone o repositório:
``git@github.com:martadrozsa/one-menu.git``


## Estrutura do Projeto

- `src/main/java/com/denisczwicz/onemenu` — Código fonte principal
- `application` 
  - Casos de uso
  - Port
- `domain`
    - Modelos de domínio
- `entrypoint`
  - Controllers
  - DTOs
  - Mapeadores
- `infrastructure`
  - Config
  - Database
    - Entidades
  - Gateway
    - Repositórios
  - Mapper


## Endpoints principais

- `POST /authenticate` — Autenticação de usuário
- `POST /users` — Criação de usuário
- `PUT /users/{id}` — Atualização de dados cadastrais
- `PUT /users/{id}/credentials` — Atualização de credenciais
- `GET /users/{id}` — Consulta de usuário
- `GET /users` — Listagem de usuários
- `DELETE /users/{id}` — Exclusão de usuário

## Testes

Para rodar os testes:
