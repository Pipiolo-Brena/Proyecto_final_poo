/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Pagos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public abstract class MetodosPago implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double monto; // Monto a pagar 
    
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public abstract boolean validarPago();
    
    public abstract void realizarPago(double monto);
}
