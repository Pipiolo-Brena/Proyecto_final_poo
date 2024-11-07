/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pagos.Efectivo;
import java.util.Random;
import Pagos.PagosEfectivo;

/**
 *
 * @author PC
 */
public class OXXO extends PagosEfectivo {
    private String codigoPago;

    //constructor
    public OXXO(double monto, String codigoPago) {
        super(monto);
        this.codigoPago = codigoPago;
    }

    //paa pago en efectivo
    public boolean realizarPagoEnOxxo() {
        System.out.println("Por favor, realice el pago en cualquier sucursal Oxxo.");
        System.out.println("Código de pago: " + codigoPago);
        System.out.println("Monto a pagar: $" + monto);
        this.pagado = true;
        System.out.println("Pago realizado con éxito en Oxxo.");
        return pagado;
    }


    //código de pago de 10 dígitos
    public String codigoPago() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digito = random.nextInt(10);
            codigo.append(digito);
        }

        return codigo.toString();
    }

    @Override
    public String toString() {
        return "OXXO []";
    }

    //setters getters
    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

}
