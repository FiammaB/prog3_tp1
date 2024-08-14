
package com.mycompany.prog3tp1;

import java.util.Scanner;

public class Prog3TP1 {

    public static void main(String[] args) {
        Factura fac = new Factura();
        Scanner sc = new Scanner(System.in);
               //a ingresar atributos de factura     
            System.out.println("ingrese la fecha  de la factura");
            fac.setFecha(sc.nextLine());
            System.err.println("ingrese el numero de factura ");
            fac.setNroFactura(sc.nextLong());
            System.err.println("Ingrese el CLIENTE ");
            sc.nextLine();
            System.out.println("ingrese el cuit del cliente");
            fac.setCuitCliente(sc.nextLong());
            sc.nextLine();
            System.out.println("ingrese la razon social del cliente");
            fac.setRazonSocial(sc.nextLine());
           boolean validarPago= true;
            do { 
            System.out.println("ingrese el metodo de pago");
            String pago=sc.nextLine();
            if (pago.equalsIgnoreCase("C")) {
                fac.setTipoPago(pago);
                 System.out.println("el metodo de pago contado ha sido registrado ");
                
            }else if (pago.equalsIgnoreCase("TC")){
                fac.setTipoPago(pago);
                 System.out.println("el metodo de pago Tarjeta de Credito ha sido registrado ");
            }else if (pago.equalsIgnoreCase("TD")){
                fac.setTipoPago(pago);
                 System.out.println("el metodo de pago Tarjeta de Debito ha sido registrado ");
            }else{System.out.println("El  metodo de pago no esta disponible ");
            validarPago=false;}
            
            
        } while (!validarPago);
          //b solicito al usuario los articulos q voy a ingresar
          System.out.println("ingrese la cantidad  de articulos q desea ingresar");
          int cantArticulos = sc.nextInt();
          sc.nextLine();
          while (cantArticulos<=0) {          
              System.out.println("el numero ingresado es menor a cero,intente nuevamente");
            System.out.println("ingrese la cantidad  de articulos q desea ingresar");
           cantArticulos = sc.nextInt();
        }
          //c asignacion de tamaño para matriz item factura
          sc.nextLine();
          fac.setItemsFactura(new String[cantArticulos][5]);
          //d ingreso los articulos q quiero incluir en la matriz
          System.out.println("Articulos a Facturar ");
          boolean boolEncontrado=true;
          do{
          System.out.println("Ingrese el codigo del articulo");
          String codigoArt=sc.nextLine();
          CalculoFactura  calFactura= new CalculoFactura();
         calFactura.mostrarArticulos();
         String [] codigoEncontrado = calFactura.encontrarCodigo(codigoArt);
         if (codigoEncontrado==null){
             System.out.println("el codigo ingresado es incorrecto, intente nuevamente");
             boolEncontrado=false;
         }
          }while (!boolEncontrado) ;
           System.out.println("codigo encontrado!");
           System.out.println("ingrese la cantidad a facturar");
           int cantidadAFact = sc.nextInt();
           
        
    }
}
