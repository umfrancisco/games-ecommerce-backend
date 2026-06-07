# 🛒 E-commerce Backend (Games) - Projeto MVC

Este projeto implementa um backend de um e-commerce de jogos eletrônicos utilizando o padrão de arquitetura **MVC (Model-View-Controller)**. O objetivo é simular o fluxo de um sistema de compras, desde o cadastro de produtos até a finalização de pedidos.

---

## 🧱 Estrutura do Projeto

A aplicação está organizada em camadas bem definidas, seguindo boas práticas de separação de responsabilidades.

### 📦 Camada de Modelo (Model)

Localizada no pacote `model`, contém as classes **POJO (Plain Old Java Objects)** responsáveis por representar os dados da aplicação:

* **Product (Produto)**
  Classe abstrata base que define os atributos comuns a todos os produtos.

* **Game (Jogo)**
  Herda de `Product` e representa um jogo eletrônico com suas propriedades específicas.

* **ProductRequest (Solicitação de Produto)**
  Representa um item solicitado em um pedido, contendo apenas os dados relevantes do produto (como ID, preço e quantidade).

* **Cart (Carrinho de Compras)**
  Responsável por agrupar os itens do pedido (`ProductRequest`), além de armazenar o valor total da compra.

---

### 💾 Camada de Persistência (Repository)

Responsável pela comunicação com a base de dados. É composta pelas seguintes interfaces:

* **GameRepository**
  Gerencia o armazenamento e recuperação dos dados completos dos jogos.

* **RequestRepository**
  Armazena os dados necessários para o processamento dos pedidos.

* **CartRepository**
  Registra os pedidos realizados, incluindo produtos, valores e data/hora da solicitação.

---

### ⚙️ Camada de Serviço (Service)

Contém a lógica de negócio da aplicação, intermediando a comunicação entre controllers e repositories:

* **GameService**
* **CartService**

As implementações dessas interfaces são:

* **GameServiceImpl**
* **CartServiceImpl**

Essas classes são responsáveis por aplicar regras de negócio, validações e orquestrar o fluxo de dados da aplicação.

---

## 🚀 Próximos Passos

* Implementação de autenticação e autorização
* Integração com banco de dados real
* Criação de endpoints REST completos
* Deploy da aplicação

---

## 📌 Objetivo

Este projeto tem fins educacionais, com foco em demonstrar:

* Aplicação do padrão MVC
* Organização em camadas
* Estruturação de um backend escalável
* Simulação de fluxo de e-commerce

---

## 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Arquitetura MVC
* REST APIs

---

# English

---

# 🛒 E-commerce Backend (Games) - MVC Project

This project implements the backend of a video game e-commerce application using the **MVC (Model-View-Controller)** architectural pattern. The goal is to simulate the flow of a purchasing system, from product management to order completion.

---

## 🧱 Project Structure

The application is organized into well-defined layers, following best practices for separation of concerns.

### 📦 Model Layer

Located in the `model` package, this layer contains the **POJO (Plain Old Java Objects)** classes responsible for representing the application's data:

* **Product**
  An abstract base class that defines the common attributes for all products.

* **Game**
  Inherits from `Product` and represents a video game with its specific properties.

* **ProductRequest**
  Represents an item within an order, containing only the relevant product data (such as ID, price, and quantity).

* **Cart**
  Responsible for grouping order items (`ProductRequest`) and storing the total purchase value.

---

### 💾 Persistence Layer (Repository)

Responsible for handling data persistence. It consists of the following interfaces:

* **GameRepository**
  Manages the storage and retrieval of complete game data.

* **RequestRepository**
  Stores the necessary data for order processing.

* **CartRepository**
  Records completed orders, including products, total price, and request date/time.

---

### ⚙️ Service Layer

Contains the business logic of the application, acting as an intermediary between controllers and repositories:

* **GameService**
* **CartService**

Their respective implementations are:

* **GameServiceImpl**
* **CartServiceImpl**

These classes are responsible for applying business rules, validations, and orchestrating the application's data flow.

---

## 🚀 Next Steps

* Implement authentication and authorization
* Integrate with a real database
* Create complete REST endpoints
* Deploy the application

---

## 📌 Purpose

This project is intended for educational purposes, focusing on:

* Applying the MVC pattern
* Layered architecture organization
* Structuring a scalable backend
* Simulating an e-commerce workflow

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* MVC Architecture
* REST APIs

---

