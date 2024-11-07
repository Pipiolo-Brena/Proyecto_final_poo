/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos.Linea;

import java.time.LocalDateTime;

import Pagos.PagosLinea;

/**
 *
 * @author PC
 */
public class TarjetaCredito extends PagosLinea {
    

    private double saldoDeuda;

    public TarjetaCredito(String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv, double saldoDeuda) {
        super(numeroTarjeta, titular, fechaExpiracion, cvv);
        this.saldoDeuda = saldoDeuda;
    }

    @Override
    public boolean validarPago(double monto) {
        
        return true;
    }

    @Override
    public void realizarPago(double monto) {
        saldoDeuda += monto;
    }

    //getters setteres
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
