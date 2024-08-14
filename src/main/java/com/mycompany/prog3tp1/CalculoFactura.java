/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog3tp1;

/**
 *
 * @author brizu
 */
public class CalculoFactura {
  private String [][]  articulos = {{"100","azucar", "20", "U"} , {"101","Leche" , "30" , "U"} ,
{"102","Aceite", "50" , "U"} , {"103","Sal", "45" , "U"} , {"104"," Fideos", "15" , "U"} ,
{"105"," Arroz", "28" , "U"} , {"106","Galletas", "26" , "U"} , {"107","Carne Molida", "220" ,
"Kg"} , {"108","Shampoo", "42" , "U"} , {"109","Queso Mantecoso", "178" , "Kg"} ,
{"110","Jamon Cocido", "320" , "Kg"} , {"111","Naranjas", "80" , "Kg"}};

    public CalculoFactura() {
    }
    public void mostrarArticulos() {
            for (String[] articulo : articulos) {
                System.out.println("codigo: "+articulo[0]+"Denominacion"+articulo[1]+" Precio de articulo "+ articulo[2]+" medida de articulo "+ articulo[3]);
            }
        
    }
    public String []  encontrarCodigo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
           
    }   
       return null;
}
}