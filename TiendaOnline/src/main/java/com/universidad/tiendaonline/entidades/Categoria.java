package com.universidad.tiendaonline.entidades;

/**
 * Categoría a la que pertenecen los productos (ej: Tecnología, Hogar).
 *
 * @author Integrante A
 */
public class Categoria {

    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Categoria() {
    }

    /**
     * Crea una categoría.
     *
     * @param idCategoria identificador
     * @param nombre nombre de la categoría
     * @param descripcion descripción corta
     */
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
