package com.universidad.tiendaonline.entidades;

/**
 * Pago de un pedido.
 *
 * @author Integrante A
 */
public class Pago {

    private int idPago;
    private double monto;
    private MetodoPago metodo;
    private EstadoPago estado;

    public Pago() {
    }

    /**
     * Crea un pago. Empieza en estado PENDIENTE.
     *
     * @param idPago identificador
     * @param monto valor a pagar
     * @param metodo forma de pago
     */
    public Pago(int idPago, double monto, MetodoPago metodo) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = EstadoPago.PENDIENTE;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    /**
     * Marca el pago como aprobado.
     */
    public void aprobar() {
        estado = EstadoPago.APROBADO;
    }

    @Override
    public String toString() {
        return "Pago " + idPago + " - " + metodo + " - " + estado;
    }
}
