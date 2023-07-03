package com.example.clinicaOdontologica.exception;

public class BadRequestException extends  Exception{
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
