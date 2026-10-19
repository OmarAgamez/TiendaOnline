package com.universidad.tiendaonline.entidades;

/** Usuario con permisos para administrar clientes y productos. */
public class Administrador extends UsuarioWeb {

    public Administrador(String id, String nombreUsuario, String contrasena) {
        super(id, nombreUsuario, contrasena);
        setEstado(EstadoUsuario.ACTIVO);
    }

    @Override
    public String descripcion() {
        return "Administrador " + getNombreUsuario();
    }
}
