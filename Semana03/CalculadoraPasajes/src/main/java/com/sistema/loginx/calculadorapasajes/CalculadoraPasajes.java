
package com.sistema.loginx.calculadorapasajes;
import java.util.Scanner;

public class CalculadoraPasajes {
  
    private static final double PRECIO_PASAJE = 37.5;
    private static final int UMBRAL_DESCUENTO_CANTIDAD = 15;
    private static final double DESCUENTO_15_O_MAS = 0.08;
    private static final double DESCUENTO_MENOS_15 = 0.05;
    private static final int UMBRAL_CARAMELOS = 200;
    private static final int CARAMELOS_POR_BOLETO = 2;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE VENTA DE PASAJES LIMA-HUANCAYO ===\n");
        
        System.out.println("Seleccione el turno:");
        System.out.println("1. Mañana");
        System.out.println("2. Noche");
        System.out.print("Opción: ");
        int opcionTurno = scanner.nextInt();
        
        String turno = (opcionTurno == 1) ? "Mañana" : "Noche";
   
        System.out.print("\nIngrese la cantidad de pasajes: ");
        int cantidadPasajes = scanner.nextInt();
        
        double importeCompra = cantidadPasajes * PRECIO_PASAJE;
        
        double porcentajeDescuento;
        if (cantidadPasajes >= UMBRAL_DESCUENTO_CANTIDAD) {
            porcentajeDescuento = DESCUENTO_15_O_MAS;
        } else {
            porcentajeDescuento = DESCUENTO_MENOS_15;
        }
        
        double importeDescuento = importeCompra * porcentajeDescuento;
        double importeDespuesDescuento = importeCompra - importeDescuento;
 
        int cantidadCaramelos = 0;
        if (importeDespuesDescuento > UMBRAL_CARAMELOS) {
            cantidadCaramelos = cantidadPasajes * CARAMELOS_POR_BOLETO;
        }
        
        double importeAPagar = importeDespuesDescuento;
     
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN DE LA COMPRA");
        System.out.println("=".repeat(50));
        System.out.println("Turno seleccionado:           " + turno);
        System.out.println("Cantidad de pasajes:          " + cantidadPasajes);
        System.out.println("Precio por pasaje:            S/ " + String.format("%.2f", PRECIO_PASAJE));
        System.out.println("-".repeat(50));
        System.out.println("Importe de la compra:         S/ " + String.format("%.2f", importeCompra));
        System.out.println("Descuento (" + (int)(porcentajeDescuento * 100) + "%):              S/ " + String.format("%.2f", importeDescuento));
        System.out.println("-".repeat(50));
        System.out.println("IMPORTE A PAGAR:              S/ " + String.format("%.2f", importeAPagar));
        System.out.println("Caramelos de obsequio:        " + cantidadCaramelos + " unidades");
        System.out.println("=".repeat(50));
        
        scanner.close();
    }
}