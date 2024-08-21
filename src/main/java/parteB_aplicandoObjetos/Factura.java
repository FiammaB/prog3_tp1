
package parteB_aplicandoObjetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Factura {
    private String letra;
    private int numero;
    private double recargo;
    private String tipoPago;
    private double totalItems, totalFinal;
    private Date fecha;
    private Cliente cliente;
    private ArrayList<DetalleFactura> detallesFacturas = new ArrayList<>();
    private ArrayList<String[]> itemsfactura = new ArrayList<>();

    public ArrayList<String[]> getItemsfactura() {
        return itemsfactura;
    }

    public void setItemsfactura(ArrayList<String[]> itemsfactura) {
        this.itemsfactura = itemsfactura;
    }

 
    public void additemsFactura(String []item) {
         this.itemsfactura.add(item);
    }

//    public String[][] getItemsFactura() {
//        return itemsFactura;
//    }
//
//    public void setItemsFactura(String[][] itemsFactura) {
//        this.itemsFactura = itemsFactura;
//    }

    public Factura() {
    }

    public Factura(String letra, int numero, double recargo, String tipoPago, double totalItems, double totalFinal, Date fecha, Cliente cliente) {
        this.letra = letra;
        this.numero = numero;
        this.recargo = recargo;
        this.tipoPago = tipoPago;
        this.totalItems = totalItems;
        this.totalFinal = totalFinal;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(ArrayList<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(double totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void addDetalle(DetalleFactura detalle){
        this.detallesFacturas.add(detalle);
    }
    
    public DetalleFactura agregarArticulo(String[] articulo, int posicion, Scanner sc) {
        String [] items = new String[5];
        items[0]=articulo[0];
        items[1]=articulo[1];
        items[2]=articulo[2];
        String cantidadAFact=null;
        
        System.out.println("Ingrese la cantidad a facturar: ");
        if (articulo[3].equalsIgnoreCase("U")) {
            System.out.println("Ingrese un numero entero");
            cantidadAFact = sc.nextLine();

            while (cantidadAFact.contains(".") & isInteger(cantidadAFact) == false) {
                System.out.println("El numero ingresado no es un entero, intente nuevamente: ");
                cantidadAFact = sc.nextLine();
            }
            
        } else if (articulo[3].equalsIgnoreCase("KG")) {
            System.out.println("Ingrese un numero decimal: ");
            cantidadAFact = sc.nextLine();

            while (!cantidadAFact.contains(".") || !isDouble(cantidadAFact)) {
                System.out.println("No es un numero decimal, intente nuevamente: ");
                cantidadAFact = sc.nextLine();
            }
            
        }
        
        items[3]= cantidadAFact;
        
        DetalleFactura detalle = new DetalleFactura();
        detalle.setCantidad(Double.parseDouble(cantidadAFact));
        
        double precioUnitario = Double.parseDouble(articulo[2]);
        double subTotal = precioUnitario * Double.parseDouble(cantidadAFact);
        
        detalle.setSubtotal(subTotal);
        items[4] = String.valueOf(subTotal);
        additemsFactura(items);
        return detalle;      
    }
    
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void calcularMontoFinal(String tipoPago) {
         //Suma de subtotales
         
        double totalItems = 0;

        for (String[] string: itemsfactura){
            totalItems += Double.valueOf(string[4]);
            
        }
      

        //Recargo y Monto final
        double recargo = 0;
        double montoFinal = 0;

        if (tipoPago.equals("C")) {
            montoFinal = totalItems;
        } else if (tipoPago.equals("TD")) {
            recargo = 5 * totalItems / 100;
            montoFinal = totalItems + recargo;
        } else {
            recargo = 10 * totalItems / 100;
            montoFinal = totalItems + recargo;
        }
//
        mostrarMatriz( totalItems, recargo, montoFinal);
    }
    
    public void mostrarMatriz( double totalItems, double recargo, double montoFinal) {
         System.out.println(espacios("Fecha:")+espacios(String.valueOf(getFecha())));
        System.out.println(espacios("Nro° Factura:")+espacios(String.valueOf(getNumero())));
       // System.out.println(espacios("Razon Social")+espacios(getCliente().getRazonSocial));
       // System.out.println(espacios("Cuit Cliente")+espacios(String.valueOf(getCliente().getCuit())));
        System.out.println(espacios("Tipo de Pago:")+espacios(getTipoPago()));
        System.out.println(espacios("Letra: ")+espacios(getLetra()));
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(espacios("CÓDIGO")+espacios("DENOMINACIÓN ")+espacios("PRECIO UNITARIO ")+espacios("CANTIDAD") +espacios("SUBTOTAL")  );
        for (String[] strings : itemsfactura) {
            System.out.println(espacios(strings[0])+espacios(strings[1])+espacios(strings[2])+espacios(strings[3])+espacios(strings[4]));
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(espacios("TOTAL ÍTEMS = ")+espacios(String.valueOf(totalItems)) );
        System.out.println(espacios("RECARGO = ") + espacios(String.valueOf(recargo)));
        System.out.println(espacios("MONTO FINAL = " )+espacios(String.valueOf(montoFinal)) );
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
