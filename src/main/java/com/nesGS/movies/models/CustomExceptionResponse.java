package com.nesGS.movies.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Esta clase define el formato de la respuesta de error que se enviará al cliente.
@Setter
@Getter
public class CustomExceptionResponse {
    private Date date;
    private String message;
    private String details;



    public CustomExceptionResponse() {
    }


    public CustomExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }


}
