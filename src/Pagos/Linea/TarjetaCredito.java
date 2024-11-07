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

    @Override
    public boolean validarPago(double monto) {
        
        return true;
    }

    @Override
    public void realizarPago(double monto) {
        saldoDeuda += monto;
    }
}
