package com.universidad.tiendaonline.entidades;

import java.util.ArrayList;

/**
 * Carrito de compras. Guarda los ítems en un ArrayList.
 *
 * @author Integrante A
 */
public class Carrito {

    private ArrayList<ItemPedido> items;

    /**
     * Crea un carrito vacío.
     */
    public Carrito() {
        items = new ArrayList<>();
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    /**
     * Agrega un producto al carrito. Si ya estaba, suma la cantidad.
     *
     * @param producto producto a agregar
     * @param cantidad unidades a agregar
     */
    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemPedido item : items) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemPedido(producto, cantidad));
    }

    /**
     * Quita un producto del carrito.
     *
     * @param idProducto id del producto a quitar
     */
    public void eliminarProducto(int idProducto) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProducto().getIdProducto() == idProducto) {
                items.remove(i);
                return;
            }
        }
    }

    /**
     * Calcula el total del carrito.
     *
     * @return suma de los subtotales
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : items) {
            total = total + item.calcularSubtotal();
        }
        return total;
    }

    /**
     * Deja el carrito vacío.
     */
    public void vaciar() {
        items.clear();
    }
}
