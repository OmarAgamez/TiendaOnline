package com.universidad.tiendaonline.entidades;

import java.util.ArrayList;

/**
 * Cliente de la tienda. Hereda de UsuarioWeb y tiene una o más direcciones.
 */
public class Cliente extends UsuarioWeb {

    private String nombre;
    private String telefono;
    private String correoElectronico;
    private ArrayList<Direccion> direcciones;

    public Cliente() {
        this.direcciones = new ArrayList<>();
    }

    public Cliente(String id, String nombreUsuario, String contrasena,
            String nombre, String telefono, String correoElectronico) {
        super(id, nombreUsuario, contrasena);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direcciones = new ArrayList<>();
        setEstado(EstadoUsuario.ACTIVO);
    }

    /** Agrega una dirección al cliente (composición 1..*). */
    public void agregarDireccion(Direccion direccion) {
        direcciones.add(direccion);
    }

    @Override
    public String descripcion() {
        return "Cliente " + nombre + " (" + correoElectronico + ")";
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public ArrayList<Direccion> getDirecciones() { return direcciones; }
}
