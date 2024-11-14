### **Néstor GS**
(Manejo de excepciones y ResponseEntity)


# APIRest para Base de Datos de Películas 


Ejemplo de una API REST desarrollada con las siguientes características:

- **Arquitectura MVC**: Organización en capas de modelo, vista y controlador.
- **Validación de Entidades**: Aseguramiento de la integridad de datos mediante validaciones.
- **Manejo Global de Excepciones**: Gestión centralizada de errores en la API.
- **(Seguridad, documentación y autenticación pendientes)**

## Descripción

Esta API permite realizar operaciones CRUD sobre una base de datos de películas. Incluye validaciones para campos clave y un manejo centralizado de errores que proporciona respuestas consistentes a los usuarios de la API.

## Tecnologías Utilizadas

- **Spring Boot**
- **JPA/Hibernate**
- **Base de datos H2** (opcional para desarrollo)
- **Maven**

## Endpoints Principales

- `GET /movies`: Lista todas las películas.
- `POST /movies`: Crea una nueva película.
- `PUT /movies/{id}`: Actualiza una película existente.
- `DELETE /movies/{id}`: Elimina una película.
- `GET /vote/movies/{id}/{rating}`: Registra votación de una película.

## Ejemplo de JSON de Película

```json
{
    "title": "Inception",
    "releaseYear": 2010,
    "votes": 2000000,
    "rating": 8.8,
    "imageUrl": "http://example.com/inception.jpg"
}

