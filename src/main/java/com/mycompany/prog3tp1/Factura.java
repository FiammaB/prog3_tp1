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
        
            for (int j = 0; j < 5; j++) {
                if (j<3) {
                     itemsFactura[i][j] = articulo[j];
                }
               
                if (j== 3) {
                    System.out.println("ingrese la cantidad a facturar");
                    if (articulo[j].equalsIgnoreCase("U")) {
                        System.out.println("ingrese un numero entero");
                        cantidadAFact = sc.nextLine();
                        
                        while (cantidadAFact.contains(".") & isInteger(cantidadAFact) == false) {
                            System.out.println("el numero ingresado no es un entero,intente nuevamente");
                            cantidadAFact = sc.nextLine();
                        }
                    } else if (articulo[j].equalsIgnoreCase("kg")) {
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
                     System.out.println("ingresando a subtotal..");
                double resultado = Double.parseDouble(cantidadAFact) *Double.parseDouble(itemsFactura[i][2]);
                itemsFactura[i][j] = String.valueOf(resultado);
            }
            }
           
        }  
    public void montoTotalItems(int cant) {
        double costoTotal= 0;
        for (int i = 0; i <cant ; i++) {
            for (int j = 0; j < 5; j++) {
                if(j==4){
              costoTotal+=Double.parseDouble(itemsFactura[i][j]);
                    setMontoTotalItems(costoTotal);
                }
            }
        }
        
    }
    public  void recargo() {
            if (getTipoPago().equalsIgnoreCase("C")) {
                setRecargo(0);
            }else if (getTipoPago().equalsIgnoreCase("TC")) {
                double recar= getMontoTotalItems()*0.10;
                setRecargo(recar);
     
            }else{
                double recar= getMontoTotalItems()*0.05;
                setRecargo(recar);
            }
    }
    public void TotalFinal() {
        double montoFin =getMontoTotalItems()+getRecargo();
        setMontoFinal(montoFin);
        
    }
    public void mostraritems() {
        System.out.println("  ");
        System.out.println(espacios("Fecha")+espacios(getFecha()));
        System.out.println(espacios("Nro° Factura")+espacios(String.valueOf(getNroFactura())));
        System.out.println(espacios("Razon Social")+espacios(getRazonSocial()));
        System.out.println(espacios("Cuit Cliente")+espacios(String.valueOf(getCuitCliente())));
        System.out.println(espacios("Tipo de Pago")+espacios(getTipoPago()));
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.print(espacios("Código item"));
        System.out.print(espacios("Denominación"));
        System.out.print(espacios("Precio"));
        System.out.print(espacios("Cantidad"));
        System.out.println(espacios("Subtotal"));
        
        for (String[] strings : itemsFactura) {
            System.out.println(espacios(strings[0] )+espacios(strings[1])+espacios(strings[2])+espacios(strings[3])+espacios(strings[4]));
            
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println(espacios("Total items")+espacios(String.valueOf(getMontoTotalItems())));
        System.out.println(espacios("Recargo")+espacios(String.valueOf(getRecargo())));
        System.out.println(espacios("Total Final")+espacios(String.valueOf(getMontoFinal())));
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
     public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public String espacios(String palabra){
        
        int numesp=20-palabra.length();
        String espacios=" ";
        for (int i = 0; i < numesp; i++) {
             palabra+=espacios;
        }
        return palabra;
}
}
