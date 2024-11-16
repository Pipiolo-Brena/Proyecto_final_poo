/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos;

import java.util.Random;

/**
 *
 * @author PC
 */
public abstract class PagosEfectivo extends MetodosPago {
    protected String codigoPago;
    protected boolean pagado;

    public PagosEfectivo() {
        this.pagado = false;
    }
  
    public boolean isPagado() {
        return pagado;
    }
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String generarCodigoPago() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            codigo.append(random.nextInt(10));
        }
        return codigo.toString();
    }

    @Override
    public abstract boolean validarPago();
    public abstract void realizarPago(double monto);
}
