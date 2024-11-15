/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public abstract class PagosLinea extends MetodosPago {
    protected String numeroTarjeta;
    protected String titular;
    protected int cvv; //numero clave de 4 digitos

    //constructor
    public PagosLinea(String numeroTarjeta, String titular, int cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.cvv = cvv;
    }

    public abstract boolean validarPago(double monto);
    public abstract void realizarPago(double monto);

}
