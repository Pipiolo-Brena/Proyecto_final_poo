/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos;

/**
 *
 * @author PC
 */
public abstract class PagosEfectivo extends MetodosPago{
    protected double monto;
    protected boolean pagado;

    //constructor
    public PagosEfectivo() {
        
    }

    //para pago en oxxo
    public abstract boolean realizarPagoEnOxxo(String codigoPago);
    public abstract String codigoPago(String codigoPago);

    public boolean Pagado() {
        return pagado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
