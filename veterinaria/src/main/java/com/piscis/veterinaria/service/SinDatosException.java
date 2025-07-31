package com.piscis.veterinaria.service;

public class SinDatosException extends RuntimeException {
    public SinDatosException (String mensaje){
        super(mensaje);
    }
}
