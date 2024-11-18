/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public abstract class PagosLinea extends MetodosPago   {
    private static final long serialVersionUID = 1L;

    protected String numeroTarjeta;
    protected String titular;
    protected LocalDateTime fechaExpiracion;
    protected int cvv;

    public PagosLinea(double monto, String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    protected boolean esTarjetaValida() {
        return fechaExpiracion.isAfter(LocalDateTime.now());
    }

    @Override
    public abstract boolean validarPago();
    public abstract void realizarPago(double monto);
}
