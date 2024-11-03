package com.nesGS.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// La clase extiende RuntimeException, que es una excepción no verificada en Java. Esto permite q
// que la excepción se lance sin estar obligada a ser capturada o declarada en los métodos (throws).
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException  {

    // Este constructor acepta un mensaje de error (String message) y lo pasa a la clase base (RuntimeException)
    // mediante super(message).
    public MovieNotFoundException(String message) {
        super(message);
    }
}
