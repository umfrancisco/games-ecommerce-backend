# E-Commerce de Jogos Eletrônicos e Hardware

Este projeto é uma API REST de um sistema de e-commerce de Jogos Eletrônicos e Hardware desenvolvida com foco em boas práticas de arquitetura, organização de código e padrões utilizados no mercado. Ele simula operações reais como cadastro de usuários, autenticação, gerenciamento de produtos e fluxo de compras. Ele utiliza o banco de dados relacional PostgreSQL para armazenar produtos e pedidos.

## Features

- RESTful API design
- CRUD operations
- Data persistence with JPA / Hibernate
- Exception handling
- Environment-based configuration
- Authentication with JWT / Spring Security

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker

## Endpoints

| Method | Endpoint                                | Description                     |
| ------ | --------------------------------------- | ------------------------------- |
| GET    | /api/public/product                     | Get all products                |
| GET    | /api/public/product/{id}                | Get product by ID               |
| GET    | /api/public/product/category/{category} | Get product by category         |
| GET    | /api/public/product/highlight/first     | Get first highlighted product   |
| GET    | /api/public/product/highlight/all       | Get all highlighted products    |
| POST   | /api/admin/product                      | Add new product                 |
| PUT    | /api/admin/product/{id}                 | Update product                  |
| DELETE | /api/admin/product/{id}                 | Delete product                  |

## Exemplo de requisição JSON

### Exemplo de Game
<pre>
{
    "name": "game",
    "price": 100.0,
    "stock": 10,
    "description": "lorem ipsum",
    "longDescription": "lorem ipsum",
    "category": "action",
    "imageUrl": "www.image.com/image.png",
    "platforms": ["hello", "world"]
}
</pre>

### Exemplo de Hardware
<pre>
{
    "name": "hardware",
    "price": 100.0,
    "stock": 10,
    "description": "lorem ipsum",
    "longDescription": null,
    "category": "notebook",
    "imageUrl": "www.image.com/image.png",
    "platforms": null
}
</pre>

## Instalação

### 1. Clone o repositório
git clone https://github.com/umfrancisco/games-ecommerce-backend.git
cd games-ecommerce-backend 

### 2. Baixe a imagem do PostgreSQL com Docker Compose
docker compose up   

### 3. Configure as variáveis de ambiente

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres  
spring.datasource.username=postgres  
spring.datasource.password=1234  

spring.jpa.hibernate.ddl-auto=update  
server.port=8080  

### 4. Rode a aplicação

Usando Spring Boot:  

./mvnw spring-boot:run  

Build com Maven:  

mvn clean package  
java -jar target/games-ecommerce-0.0.1-SNAPSHOT.jar  





