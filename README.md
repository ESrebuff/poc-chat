# Chat Feature Proof of Concept for Your Car Your Way App

## Overview
This Proof of Concept (PoC) demonstrates the real-time chat functionality intended for the "Your Car Your Way App". It enables users to join a public chat room where they can send messages and see others' messages in real time. This PoC is built using Spring Boot for the backend and WebSocket for real-time communication.

## Features
- **User Join**: Users can enter a chat room by providing a username.
- **Send and Receive Messages**: Users can send messages and view all messages sent by others in real time.

## Technology Stack
- **Backend**: Spring Boot, using Spring WebSocket and STOMP for managing real-time messaging.
- **Frontend**: Simple HTML and JavaScript to interact with the WebSocket server.
- **Dependency Management**: Maven.

## Dependencies
This project relies on several Maven dependencies to function:

- **Spring Boot Starter Web**: Provides all the necessary dependencies for building web applications. This includes embedded Tomcat and Spring MVC.
- **Spring Boot Starter WebSocket**: Facilitates building WebSocket applications using Spring. It provides the functionality needed to handle real-time messaging.
- **Lombok**: Simplifies the codebase by automatically generating getters, setters, constructors, builders, and more through annotations.

These dependencies ensure that the application has support for web applications, real-time web socket communication, and simplifies the Java code with Lombok.

## Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.6 or higher

### Setup and Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/your-repository/your-car-your-way-chat-poc.git
   cd your-car-your-way-chat-poc

2. **Build the project**
    ```bash
    mvn clean install

2. **Run the application**
    ```bash
    mvn spring-boot:run

4. **Access the application**
    Open your web browser and navigate to http://localhost:8080. Enter a username to join the chat room.
