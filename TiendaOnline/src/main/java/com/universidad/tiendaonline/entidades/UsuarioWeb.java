package com.universidad.tiendaonline.entidades;

import java.util.Date;

/**
 * Clase padre: representa a cualquier usuario que puede ingresar al sistema.
 * Cliente y Administrador heredan de ella.
 */
public class UsuarioWeb {

    private String id;
    private String nombreUsuario;
    private String contrasena;
    private EstadoUsuario estado;
    private Date fechaRegistro;

    public UsuarioWeb() {
    }

    public UsuarioWeb(String id, String nombreUsuario, String contrasena) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.estado = EstadoUsuario.NUEVO;
        this.fechaRegistro = new Date();
    }

    /** Verifica si las credenciales coinciden con las de este usuario. */
    public boolean autenticar(String usuario, String clave) {
        return nombreUsuario.equals(usuario) && contrasena.equals(clave)
                && estado != EstadoUsuario.BLOQUEADO
                && estado != EstadoUsuario.PROHIBIDO;
    }

    /** Descripción corta; las subclases la sobrescriben (polimorfismo). */
    public String descripcion() {
        return "Usuario " + nombreUsuario;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public EstadoUsuario getEstado() { return estado; }
    public void setEstado(EstadoUsuario estado) { this.estado = estado; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
