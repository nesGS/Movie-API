package com.nesGS.movies.controllers;

import com.nesGS.movies.exceptions.MovieNotFoundException;
import com.nesGS.movies.models.CustomExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// Este controlador centraliza el manejo de excepciones personalizadas y define cómo deben ser manejadas y respondidas.
// Utiliza @ControllerAdvice para capturar excepciones en toda la aplicación.
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    // Este método se ejecuta cuando se lanza la excepción MovieNotFoundException (excepción personalizada)
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Object> handleHeroNotFoundException(Exception ex, WebRequest request) {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }

    // Este método se ejecuta cuando se lanza la excepción DataIntegrityViolationException (problemas con la persistencia)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(
                new Date(),
                "Data integrity violation: " + ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(customExceptionResponse, HttpStatus.CONFLICT); // Puedes ajustar el status a 409 Conflict
    }



    // Este método se ejecuta cuando se lanza cualquier excepción que no sea MovieNotFoundException
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCustomExceptions(Exception ex, WebRequest request) {

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}