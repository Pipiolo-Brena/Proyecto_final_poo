/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos.Efectivo;

import java.io.Serializable;

import Pagos.PagosEfectivo;

/**
 *
 * @author PC
 */
public class OXXO extends PagosEfectivo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codigoPago;

    //constructor
    public OXXO() {
        this.codigoPago = generarCodigoPago();
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    @Override
    public boolean validarPago() {
        return !pagado;
    }

    @Override
    public void realizarPago(double monto) {
        if(validarPago()) {
            System.out.println("Por favor, realice el pago en cualquier sucursal OXXO.");
            System.out.println("Código de pago: " + codigoPago);
            System.out.println("Monto a pagar: $" + monto);
            setPagado(true);

            System.out.println("Pago realizado con éxito en Oxxo.");
        } else {
            System.out.println("El pago ya se realizó previamente.");
        }
    }

    @Override
    public String toString() {
        return "OXXO [monto= "+ monto +", codigoPago="+ codigoPago +", pagado="+ pagado +"]";
    }
}
