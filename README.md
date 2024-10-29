<h1 align="center">📚 TO DO LIST</h1>



![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) 

## Resumo

Esta aplicação tem o objetivo de ser uma lista de tarefas, onde o usuário pode realizar as operações que compõem o CRUD.

## Tecnologias

- **Linguagens**:  Java
- **Frameworks**: Spring Boot
- **Banco de Dados**: MySQL e H2 (testes)
- **Outras ferramentas**: Git e Postman

## Práticas Adotadas

- **Testes Automatizados**: Implementação de testes unitários e de integração para garantir a qualidade do código.
- **Versionamento de Código**: Utilização do Git para controle de versões e colaboração.
- **Documentação**: Manutenção de documentação clara e detalhada para facilitar a compreensão e uso da aplicação.
- Consultas com Spring Data JPA
- Geração automática do Swagger 
- API REST
  

## Como Executar a Aplicação

### Pré-requisitos

- Spring Boot
- Java 17
- MySql
- Postman

### Passos para Executar

1. **Clone o repositório:**
```bash
  git clone https://github.com/brngri/api-To-do-list.git
```
2. **Inicie a aplicação:**
  TodolistApplication.java -> botão esquerdo no arquivo -> Run Java
  
3. **Entre no Postman**

#### LISTAR (GET)

URL:
```url
localhost:8080/todo
```

#### CRIAR (POST)

URL:
```url
localhost:8080/todo
```
Body:
```JSON
{
  "titulo": "Tarefa",
  "descricao": "Fazer caderno",
  "realizado": false,
  "data": "2024-10-26"
}
````

#### ATUALIZAR (PUT)

obs: O numero 1 na url é o ID da tarefa, pode ser qualquer outro ID

URL:
```url
localhost:8080/todo/1
```
Body:
```JSON
{
  "titulo": "Tarefa",
  "descricao": "Fazer caderno",
  "realizado": false,
  "data": "2024-10-26"
}
```

#### DELETAR (DELETE)

obs: O numero 1 na url é o ID da tarefa, pode ser qualquer outro ID

URL:
```url
localhost:8080/todo/1
```

### Swagger

Você pode acessar o swagger digitando (aplicação deve estar rodando): http://localhost:8080/swagger-ui.html
