# Overview

This project is a backend service developed using Spring Boot. It exposes REST APIs for handling business logic, database interactions, and authentication.

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

## Project Structure
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

### FIND ALL PRODUCTs
GET /api/product

### FIND PRODUCT BY ID
GET /api/product/{id}

### FIND PRODUCT BY CATEGORY
GET /api/product/category/{category}

### SAVE PRODUCT
POST /api/product

### UPDATE PRODUCT
PUT /api/product/{id}

### DELETE PRODUCT
DELETE /api/product/{id}

## JSON Request Example

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




