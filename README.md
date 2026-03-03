# api.blog

Microservicio REST desarrollado con **Spring Boot** para la gestión de publicaciones de blog.
Expone endpoints HTTP para operaciones CRUD sobre recursos del dominio (posts, usuarios, etc.).

---

## 🚀 Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Maven
- Base de datos relacional (MySQL / PostgreSQL / H2)

---

## 📦 Arquitectura

El proyecto sigue una arquitectura en capas:

```
controller → service → repository → database
```

- **Controller**: Maneja las peticiones HTTP.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Acceso a datos mediante JPA.
- **SecurityConfig**: Configuración de seguridad (si aplica).

---

## ⚙️ Configuración

### 1️⃣ Clonar repositorio

```bash
mvn spring-boot:run
```

O:

```bash
mvn clean install
java -jar target/api.blog-0.0.1-SNAPSHOT.jar
```

El servidor iniciará en:

```
http://localhost:8080
```

---

## 📌 Endpoints principales

Ejemplo genérico:

| Método | Endpoint | Descripción |
| ------ | -------- | ----------- |

---

## 🔐 Seguridad

Si el proyecto incluye Spring Security:

- Autenticación basada en JWT / Basic Auth (según implementación).
- Endpoints protegidos según configuración en `SecurityConfig`.

---

## 🧪 Pruebas

Para ejecutar pruebas:

```bash
mvn test
```

---

## 🗂️ Estructura del proyecto

```
src/main/java/com/tuempresa/apiblog
│
├── controller
├── service
├── repository
├── model
├── config
└── Application.java
```

---

## 📄 Variables de entorno recomendadas

Para producción se recomienda usar variables:

```
DB_URL
DB_USERNAME
DB_PASSWORD
JWT_SECRET
```

---

## 📌 Estado del proyecto

En desarrollo 🚧

---

## 👨‍💻 Autor

Tu Nombre
Proyecto personal / académico
