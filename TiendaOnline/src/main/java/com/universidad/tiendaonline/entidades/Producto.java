package com.universidad.tiendaonline.entidades;

/**
 * Producto que se vende en la tienda online.
 *
 * @author Integrante A
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private Categoria categoria;

    public Producto() {
    }

    /**
     * Crea un producto.
     *
     * @param idProducto identificador
     * @param nombre nombre del producto
     * @param descripcion descripción corta
     * @param precio precio por unidad
     * @param stock unidades disponibles
     * @param categoria categoría del producto
     */
    public Producto(int idProducto, String nombre, String descripcion,
            double precio, int stock, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Revisa si hay unidades suficientes.
     *
     * @param cantidad unidades que se quieren comprar
     * @return true si el stock alcanza
     */
    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    /**
     * Descuenta unidades del stock.
     *
     * @param cantidad unidades vendidas
     */
    public void reducirStock(int cantidad) {
        stock = stock - cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
