# one-menu

Projeto desenvolvido em Java com Spring Boot para gerenciamento de usuários e autenticação.

## Requisitos

- Java 21
- Gradle
- Banco de dados MySQL
- Postman (opcional, para testes de API)
- Docker (opcional, para rodar o banco de dados)

## Endpoints principais

- `POST /authenticate` — Autenticação de usuário
- `POST /users` — Criação de usuário
- `PATCH /users/{id}` — Atualização de dados cadastrais
- `PATCH /users/{id}/credentials` — Atualização de credenciais
- `GET /users/{id}` — Consulta de um usuário
- `GET /users` — Listagem de usuários
- `DELETE /users/{id}` — Exclusão de um usuário


## Arquitetura

A arquitetura definida neste projeto é a Clean Architecture com Hexagonal. Na qual buscou-se separar claramente regras de negócio, os casos de uso, pontos de entrada da aplicação e a infraestrutura. Essa estrutura proporciona um alto nível de desacoplamento entre os módulos, o que torna o sistema mais modular, testável e adaptável a mudanças.

## Como rodar o projeto

### Instruções para execução local com o Docker
Antes de utilizar o docker compose, é necessário compilar uma imagem da aplicação one-menu utilizando seu Dockerfile na raiz do projeto:

`$ docker build -t one-menu .`


O comando anterior gera uma imagem da aplicação Java com a tag ‘one-menu’.

Assim que a imagem da aplicação estiver disponível, é possível utilizar o docker compose para inicializar a solução utilizando o comando:

`$ docker compose up`

Assim que os serviços forem inicializados, a aplicação estará disponível no endereço http://localhost:8080/users.


### Execução local sem o uso de docker

1. Clone o repositório:
   ``git@github.com:martadrozsa/one-menu.git``

Para a execução local sem o uso de docker, é necessário disponibilizar uma instância da base MySQL e pode-se configurar as seguintes variáveis de ambiente do projeto:

* DB_HOST - host da base de dados MySQL (default: localhost)
* DB_PORT - porta da base de dados MySQL (default: 3306)
* DB_USERNAME - nome do usuário para acessar o banco de dados MySQL (valor definido: root)
* DB_PASSWORD - senha do usuário para acessar o banco de dados MySQL (valor definido: root)password
* DB_SCHEMA - nome do schema (valor definido: one-menu)

## Collections
As collections do Postman estão disponíveis neste [link](https://drive.google.com/file/d/1y7EreuaRi2dtHqvDn3WCK5C1u5RxwYQ7/view?usp=drive_link). 
Faça o download e importe no Postman para testar os endpoints da API.

