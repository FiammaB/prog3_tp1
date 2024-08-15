/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog3tp1;

import java.util.Scanner;

/**
 *
 * @author brizu
 */
public class Factura {

    private String fecha;
    private long nroFactura;
    private String razonSocial;//Cliente
    private long cuitCliente;//(Cliente)
    private String tipoPago;
    private double montoTotalItems;
    private double recargo;
    private double montoFinal;
    private String[][] itemsFactura;

    public Factura() {
    }

    public Factura(String fecha, long nroFactura, String razonSocial, long cuitCliente, String tipoPago, double montoTotalItems, double recargo, double montoFinal, String[][] itemsFactura) {
        this.fecha = fecha;
        this.nroFactura = nroFactura;
        this.razonSocial = razonSocial;
        this.cuitCliente = cuitCliente;
        this.tipoPago = tipoPago;
        this.montoTotalItems = montoTotalItems;
        this.recargo = recargo;
        this.montoFinal = montoFinal;
        this.itemsFactura = itemsFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(long nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMontoTotalItems() {
        return montoTotalItems;
    }

    public void setMontoTotalItems(double montoTotalItems) {
        this.montoTotalItems = montoTotalItems;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getItemsFactura() {
        return itemsFactura;
    }

    public void setItemsFactura(String[][] itemsFactura) {
        this.itemsFactura = itemsFactura;
    }

    public void llenarItems(String[] articulo, Scanner sc,int i ) {
        String cantidadAFact=null;
        
            for (int j = 0; j < 4; j++) {
                itemsFactura[i][j] = articulo[j];
                if (j== 3) {
                    System.out.println("ingrese la cantidad a facturar");
                    if (itemsFactura[i][j].equalsIgnoreCase("U")) {
                        System.out.println("ingrese un numero entero");
                        cantidadAFact = sc.nextLine();
                        
                        while (cantidadAFact.contains(".") & isInteger(cantidadAFact) == false) {
                            System.out.println("el numero ingresado no es un entero,intente nuevamente");
                            cantidadAFact = sc.nextLine();
                        }
                    } else if (itemsFactura[i][j].equalsIgnoreCase("kg")) {
                        System.out.println("ingrese un numero decimal");
                        cantidadAFact = sc.nextLine();
                        //habria q ver un metodo para  para confirmar q es double
                        while (!cantidadAFact.contains(".")) {
                            System.out.println("no es un numero decimal, intente nuevamente");
                            cantidadAFact = sc.nextLine();
                        }
                    }
                    itemsFactura[i][j] = cantidadAFact;
                }
                 if (j == 4) {
                int resultado = Integer.valueOf(cantidadAFact) * Integer.valueOf(itemsFactura[i][2]);
                itemsFactura[i][j] = String.valueOf(resultado);
            }
            }
           
        }


    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
