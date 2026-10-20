package com.universidad.tiendaonline.entidades;

import java.util.ArrayList;

/**
 * Pedido que hace un cliente. Guarda sus ítems en un ArrayList.
 *
 * @author Integrante A
 */
public class Pedido {

    private int idPedido;
    private Cliente cliente;
    private String fecha;
    private EstadoPedido estado;
    private ArrayList<ItemPedido> items;
    private Pago pago;

    /**
     * Crea un pedido en estado PENDIENTE.
     *
     * @param idPedido identificador
     * @param cliente cliente que compra
     * @param fecha fecha del pedido (ej: 19/10/2026)
     */
    public Pedido(int idPedido, Cliente cliente, String fecha) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = EstadoPedido.PENDIENTE;
        this.items = new ArrayList<>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public ArrayList<ItemPedido> getItems() {
        return items;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    /**
     * Agrega un ítem al pedido.
     *
     * @param item ítem a agregar
     */
    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    /**
     * Calcula el total del pedido.
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

    @Override
    public String toString() {
        return "Pedido " + idPedido + " - " + estado + " - $" + calcularTotal();
    }
}
