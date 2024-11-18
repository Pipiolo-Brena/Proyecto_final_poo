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
public class TerjataDebito extends PagosLinea {
    private static final long serialVersionUID = 1L;
    private double saldo;

    public TerjataDebito(double monto, String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv, double saldoInicial) {
        super(monto, numeroTarjeta, titular, fechaExpiracion, cvv);
        this.saldo = saldoInicial;
    }


    @Override
    public boolean validarPago() {
        return esTarjetaValida() && saldo >= monto;
    }

    @Override
    public void realizarPago(double monto) {
        if (validarPago()) {
            saldo -= monto;
            System.out.println("Pago realizado. Saldo restante: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente o tarjeta inválida.");
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
