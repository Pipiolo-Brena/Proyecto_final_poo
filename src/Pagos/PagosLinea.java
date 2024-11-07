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
public abstract class PagosLinea  {
    protected String numeroTarjeta;
    protected String titular;
    protected LocalDateTime fechaExpiracion;
    protected int cvv; //numero clave de 4 digitos

    

    //constructor
    public PagosLinea(String numeroTarjeta, String titular, LocalDateTime fechaExpiracion, int cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    public abstract boolean validarPago(double monto);
    public abstract void realizarPago(double monto);

}
