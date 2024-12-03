# ms-user

## Descrição

O `ms-user` é um microserviço desenvolvido como parte do Tech Challenge da FIAP, com foco no gerenciamento de usuários em um sistema de gestão compartilhado para restaurantes. Este serviço permite operações básicas de CRUD, validação de login e gerenciamento de senhas, utilizando Java 21, Spring Boot 3 e PostgreSQL.

Este projeto faz parte do curso da FIAP e visa consolidar conhecimentos em backend, arquitetura de sistemas e orquestração com Docker.

## Funcionalidades

- Registrar novos usuários com dados como nome, email, login, senha e endereço.
- Modificar informações cadastradas dos usuários.
- Excluir permanentemente um usuário do sistema.
- Validar login, verificando se login e senha são válidos.
- Atualizar a senha do usuário.

---

## Tecnologias Utilizadas

- Linguagem: Java 21
- Frameworks:
  - Spring Boot 3 (Web, Data JPA)
- Banco de Dados: PostgreSQL
- Orquestração: Docker, Docker Compose
- Documentação e Teste de Endpoints: Arquivos `.http` e Swagger/OpenAPI

---

## Instalação e Execução

### Pré-requisitos

- Docker e Docker Compose instalados
- JDK 21 ou superior
- Maven 3.8 ou superior

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/joaovictorf01/ms-user.git
   cd ms-user
   ```

2. Compile e construa o projeto:

   ```bash
   mvn clean install
   ```

3. Suba o ambiente com Docker Compose:

   ```bash
   docker-compose up --build
   ```

4. Acesse a aplicação:

   - A API estará disponível em: `http://localhost:8080`

---

## Documentação Interativa (Swagger)

A documentação da API pode ser acessada por meio do Swagger UI, gerado automaticamente pelo Springdoc OpenAPI, assim como por arquivos `.http` incluídos no projeto.

- URL para a documentação: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Essa documentação permite explorar e testar todos os endpoints diretamente no navegador.

---

## Endpoints da API

| Método | Endpoint             | Descrição                      |
|--------|-----------------------|--------------------------------|
| POST   | `/users`             | Criação de usuário             |
| GET    | `/users/{id}`        | Buscar usuário pelo ID         |
| PUT    | `/users/{id}`        | Atualizar dados do usuário     |
| DELETE | `/users/{id}`        | Excluir usuário                |
| POST   | `/users/login`        | Validar login e senha          |
| PUT    | `/users/{id}/password` | Atualizar senha do usuário    |

---

## Considerações Finais

Este projeto foi desenvolvido com foco nos objetivos propostos pela Fase 1 do Tech Challenge FIAP. A documentação foi feita utilizando arquivos `.http` para testes rápidos e Swagger/OpenAPI para consulta interativa. Testes unitários, segurança avançada e outras melhorias podem ser adicionadas futuramente conforme a evolução do projeto.

---

## Contato

- Autor: João Victor  
- Email: <joaovictorf01@gmail.com>
