# Overview

Este projeto é uma API REST de um sistema de e-commerce desenvolvida com foco em boas práticas de arquitetura, organização de código e padrões utilizados no mercado. Ele simula operações reais como cadastro de usuários, autenticação, gerenciamento de produtos e fluxo de compras.

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

## Estrutura do projeto
<pre>

├── main
│   ├── java
│   │   └── com
│   │       └── umfrancisco
│   │           └── shoppingcart
│   │               ├── config
│   │               │   ├── JwtConstant.java
│   │               │   ├── JwtProvider.java
│   │               │   ├── JwtTokenValidator.java
│   │               │   ├── SecurityConfiguration.java
│   │               │   └── UserSession.java
│   │               ├── controller
│   │               │   ├── CartController.java
│   │               │   ├── LoginController.java
│   │               │   ├── ProductController.java
│   │               │   └── UserController.java
│   │               ├── model
│   │               │   ├── AuthResponse.java
│   │               │   ├── Cart.java
│   │               │   ├── ItemRequest.java
│   │               │   ├── Product.java
│   │               │   ├── User.java
│   │               │   └── UserRequest.java
│   │               ├── repository
│   │               │   ├── CartRepository.java
│   │               │   ├── ProductRepository.java
│   │               │   ├── RequestRepository.java
│   │               │   └── UserRepository.java
│   │               ├── service
│   │               │   ├── CartServiceImpl.java
│   │               │   ├── CartService.java
│   │               │   ├── ProductServiceImpl.java
│   │               │   ├── ProductService.java
│   │               │   └── UserServiceImpl.java
│   │               └── ShoppingCartApplication.java
│   └── resources
│       ├── application.properties
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── umfrancisco
                └── shoppingcart
                    └── ShoppingCartApplicationTests.java

</pre>

## Endpoints

| Method | Endpoint                                | Description         |
| ------ | --------------------------------------- | ------------------- |
| GET    | /api/public/product                     | Get all products    |
| GET    | /api/public/product/{id}                | Get product by ID   |
| GET    | /api/public/product/category/{category} | Get product by ID   |
| POST   | /api/admin/product                      | Create new product  |
| PUT    | /api/admin/product/{id}                 | Update product      |
| DELETE | /api/admin/product/{id}                 | Delete item         |

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
git clone https://github.com/umfrancisco/shopping-cart-backend  
cd shopping-cart-backend  

### 2. Configure as variáveis de ambiente

spring.datasource.url=jdbc:postgresql://localhost:5432/your_db  
spring.datasource.username=postgres  
spring.datasource.password=secret  

spring.jpa.hibernate.ddl-auto=update  
server.port=8080  

### 3. Rode a aplicação

Usando Spring Boot:  

./mvnw spring-boot:run  

Build com Maven:  

mvn clean package  
java -jar target/shopping-cart-0.0.1-SNAPSHOT.jar  





