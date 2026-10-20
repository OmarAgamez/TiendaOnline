package com.universidad.tiendaonline.entidades;

/**
 * Una línea del carrito o del pedido: un producto y la cantidad que se compra.
 *
 * @author Integrante A
 */
public class ItemPedido {

    private Producto producto;
    private int cantidad;

    public ItemPedido() {
    }

    /**
     * Crea un ítem.
     *
     * @param producto producto que se compra
     * @param cantidad unidades
     */
    public ItemPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal del ítem.
     *
     * @return precio del producto por la cantidad
     */
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + cantidad;
    }
}
