/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Pagos;

/**
 *
 * @author PC
 */
public interface MetodosPago {
    boolean formaDePago();
    boolean validarPago(double monto);
    void realizarPago(double monto);
}
