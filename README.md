# 🚀 API REST - Gestión de Cursos y Tutores (Backend)

Servicio web desarrollado como prueba técnica para la administración de cursos académicos y sus respectivos docentes (tutores), construido utilizando **Java 21**, **Spring Boot 4** y **Springdoc OpenAPI (Swagger)**.

---

## 🛠️ Tecnologías y Stack Tecnológico

* **Java 21**
* **Spring Boot 4** (Web, Data JPA, Validation)
* **Springdoc OpenAPI 2.x (Swagger UI)** para documentación y pruebas interactivas
* **Base de Datos:** MySQL
* **Gestor de dependencias:** Maven

---

## 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:
* [Java Development Kit (JDK) 21 o superior](https://adoptium.net/)
* [Maven](https://maven.apache.org/)
* [MySQL Server](https://www.mysql.com/)

---

## ⚙️ Configuración y Puesta en Marcha

### 1. Clonar el repositorio
```bash
git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)
cd tu-repositorio/backend
```

## configurar credenciales
spring.datasource.url=jdbc:mysql://localhost:3306/db_courses?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## ejecuta 
mvn spring-boot:run