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
public class TerjataDebito extends PagosLinea {
    private double saldo;

    public TerjataDebito(String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv, double saldo) {
        super(numeroTarjeta, titular, fechaExpiracion, cvv);
        this.saldo = saldo;
    }


    @Override
    public boolean validarPago(double monto) {
        return saldo >= monto;
    }

    @Override
    public void realizarPago(double monto) {
        if (validarPago(monto)) {
            saldo -= monto;
            //para realizar el pago
        }
    }


    //getters setters
    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
