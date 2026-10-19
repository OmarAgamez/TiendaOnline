package com.universidad.tiendaonline;

import com.universidad.tiendaonline.datos.UsuarioRepositorio;
import com.universidad.tiendaonline.presentacion.Login;
import com.universidad.tiendaonline.servicios.UsuarioServicio;

/**
 * Clase principal: arma las capas y abre la ventana de ingreso.
 */
public class TiendaOnline {

    public static void main(String[] args) {
        UsuarioServicio servicio = new UsuarioServicio(new UsuarioRepositorio());
        java.awt.EventQueue.invokeLater(() -> new Login(servicio).setVisible(true));
    }
}
