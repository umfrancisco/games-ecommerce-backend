# 🛒 E-commerce Backend (Games) - MVC Project

This project implements the backend of a video game e-commerce application using the **MVC (Model-View-Controller)** architectural pattern. The goal is to simulate the flow of a purchasing system, from product management to order completion.

---

## Demonstration

[![Demo](https://img.youtube.com/vi/bM5NW24_7Oo/0.jpg)](https://www.youtube.com/watch?v=bM5NW24_7Oo)

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

