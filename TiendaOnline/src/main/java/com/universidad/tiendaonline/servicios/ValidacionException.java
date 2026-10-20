package com.universidad.tiendaonline.servicios;

/**
 * Se lanza cuando los datos recibidos por un servicio no cumplen
 * las reglas de negocio (campos vacíos, ID o usuario repetidos, etc.).
 */
public class ValidacionException extends Exception {

    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}