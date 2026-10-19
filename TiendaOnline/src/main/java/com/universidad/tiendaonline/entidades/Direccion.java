package com.universidad.tiendaonline.entidades;

/** Dirección de entrega de un cliente. */
public class Direccion {

    private String id;
    private String calle;
    private String ciudad;
    private String departamento;
    private String codigoPostal;
    private String tipo;

    public Direccion(String id, String calle, String ciudad, String departamento,
            String codigoPostal, String tipo) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getDepartamento() { return departamento; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getTipo() { return tipo; }
}
