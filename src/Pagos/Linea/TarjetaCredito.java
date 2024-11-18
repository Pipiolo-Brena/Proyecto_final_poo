/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos.Linea;

import java.io.Serializable;
import java.time.LocalDateTime;
import Pagos.PagosLinea;

/**
 *
 * @author PC
 */
public class TarjetaCredito extends PagosLinea implements Serializable  {
    private static final long serialVersionUID = 1L;
    private double saldoDeuda;

    public TarjetaCredito(double monto, String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv, double saldoDeuda) {
        super(monto, numeroTarjeta, titular, fechaExpiracion, cvv);
        this.saldoDeuda = 0.0;
    }

    @Override
    public boolean validarPago() {
        return esTarjetaValida();
    }

    @Override
    public void realizarPago(double monto) {
        saldoDeuda += monto;
        System.out.println("Pago registrado en tarjeta de crédito. Nueva deuda: $" + saldoDeuda);
    }


    public double getSaldoDeuda() {
        return saldoDeuda;
    }
    public void setSaldoDeuda(double saldoDeuda) {
        this.saldoDeuda = saldoDeuda;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
