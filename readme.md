# ms-user

## Descrição

O `ms-user` é um microserviço desenvolvido como parte do Tech Challenge da FIAP, com foco no gerenciamento de usuários em um sistema de gestão compartilhado para restaurantes. Este serviço permite operações básicas de CRUD, validação de login e gerenciamento de senhas, utilizando Java 21, Spring Boot 3 e PostgreSQL.

Este projeto faz parte do curso da FIAP e visa consolidar conhecimentos em backend, arquitetura de sistemas e orquestração com Docker.

## Funcionalidades

- Cadastro de Usuários: Registra novos usuários com dados como nome, email, login, senha e endereço.
- Atualização de Dados: Permite modificar as informações cadastradas.
- Exclusão de Usuários: Remove permanentemente um usuário do sistema.
- Validação de Login: Verifica se login e senha são válidos.
- Troca de Senha: Permite a atualização da senha do usuário.

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

A documentação da API pode ser acessada por meio do Swagger UI, gerado automaticamente pelo Springdoc OpenAPI.

- URL para a documentação: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Essa documentação permite explorar e testar todos os endpoints diretamente no navegador.

---

## Estrutura do Projeto

```plaintext
ms-user
├── src/main/java
│   ├── com.jvfmend.msuser
│   │   ├── controller    # Controladores REST
│   │   ├── service       # Lógica de negócios
│   │   ├── repository    # Interfaces JPA
│   │   ├── entity        # Entidades e mapeamento JPA
│   │   ├── dto           # Data Transfer Objects
│   │   └── config        # Configurações gerais
├── src/main/resources
│   ├── application.yml   # Configurações do Spring Boot
├── *.http                # Arquivos .http para teste e documentação
├── Dockerfile            # Configuração Docker
├── docker-compose.yml    # Configuração Docker Compose
└── README.md             # Documentação do projeto
```

---

## Endpoints da API

| Método | Endpoint             | Descrição                      |
|--------|-----------------------|--------------------------------|
| POST   | `/users`             | Criação de usuário             |
| GET    | `/users/{id}`        | Buscar usuário pelo ID         |
| PUT    | `/users/{id}`        | Atualizar dados do usuário     |
| DELETE | `/users/{id}`        | Excluir usuário                |
| POST   | `/auth/login`        | Validar login e senha          |
| PUT    | `/users/{id}/password` | Atualizar senha do usuário    |

---

## Considerações Finais

Este projeto foi desenvolvido com foco nos objetivos propostos pela Fase 1 do Tech Challenge FIAP. A documentação foi feita utilizando arquivos `.http` para testes rápidos e Swagger/OpenAPI para consulta interativa. Testes unitários, segurança avançada e outras melhorias podem ser adicionadas futuramente conforme a evolução do projeto.

---

## Contato

- Autor: João Victor  
- Email: <joaovictorf01@gmail.com>
