/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.zonajava.tiendadescuentospordocenas;

/**
 *
 * @author Lenovo
 */
public class TiendaDescuentosporDocenas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
import java.util.Scanner;

import java.text.DecimalFormat;

public class TiendaVectoresPrimitivos {

    private static final int capacidadmaxima = 50;
    private static final String moneda = "S/. ";

    private static String[] nombres = new String[capacidadmaxima];
    private static double[] precios = new double[capacidadmaxima];
    private static int[] cantidades = new int[capacidadmaxima];
    private static double[] costosTotal = new double[capacidadmaxima];

    private static int totalProductos = 0;

    private static DecimalFormat formatoMoneda = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE GESTION DE PRODUCTOS - TIENDA DE ABARROTES ===");
        System.out.println("Capacidad maxima: " + capacidadmaxima + " productos");
        System.out.println("Moneda utilizada: Soles Peruanos (PEN)");
        System.out.println();

        ingresarDatosProductos(scanner);
        mostrarTodosLosDatos();

        scanner.close();
    }

    private static void ingresarDatosProductos(Scanner scanner) {
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s") && totalProductos < capacidadmaxima) {
            System.out.println("--- REGISTRO DE PRODUCTO " + (totalProductos + 1) + " ---");

            System.out.print("Ingrese el nombre del producto: ");
            scanner.nextLine();
            nombres[totalProductos] = scanner.nextLine();

            System.out.print("Ingrese el precio unitario (" + moneda + "): ");
            precios[totalProductos] = scanner.nextDouble();

            while (precios[totalProductos] <= 0) {
                System.out.print("El precio debe ser mayor a 0. Ingrese nuevamente: ");
                precios[totalProductos] = scanner.nextDouble();
            }

            System.out.print("Ingrese la cantidad existente: ");
            cantidades[totalProductos] = scanner.nextInt();

            while (cantidades[totalProductos] < 0) {
                System.out.print("La cantidad no puede ser negativa. Ingrese nuevamente: ");
                cantidades[totalProductos] = scanner.nextInt();
            }

            costosTotal[totalProductos] = precios[totalProductos] * cantidades[totalProductos];

            totalProductos++;

            if (totalProductos < capacidadmaxima) {
                System.out.print("¿Desea ingresar otro producto? (s/n): ");
                continuar = scanner.next();
            } else {
                System.out.println("Se alcanzo la capacidad maxima de productos.");
                continuar = "n";
            }

            System.out.println();
        }
    }

    private static void mostrarTodosLosDatos() {
        System.out.println("reporte completo");
        System.out.println();

        if (totalProductos == 0) {
            System.out.println("No hay productos registrados en el sistema.");
            return;
        }
        System.out.println(" NUMERO        NOMBRE PRODUCTO         PRECIO    CANTIDAD   COSTO TOTAL  ");

        double valorTotalInventario = 0;

        for (int i = 0; i < totalProductos; i++) {
            System.out.printf("| %-7d | %-25s | %s%-7s | %-8d | %s%-11s |\n",
                    (i + 1),
                    nombres[i],
                    moneda,
                    formatoMoneda.format(precios[i]),
                    cantidades[i],
                    moneda,
                    formatoMoneda.format(costosTotal[i])
            );/
            valorTotalInventario += costosTotal[i];
        }

       

        System.out.println();
        System.out.println("resumen del inventario");
        System.out.println("Total de productos registrados: " + totalProductos);
        System.out.println("Valor total del inventario: " + moneda + formatoMoneda.format(valorTotalInventario));

        if (totalProductos > 0) {
            int indiceMayorValor = 0;
            for (int i = 1; i < totalProductos; i++) {
                if (costosTotal[i] > costosTotal[indiceMayorValor]) {
                    indiceMayorValor = i;
                }
            }

            System.out.println("Producto con mayor valor en inventario: " + nombres[indiceMayorValor]
                    + " (" + moneda + formatoMoneda.format(costosTotal[indiceMayorValor]) + ")");
        }
    }
}


// sistema de gestion de productostienda de abarrotes
// version: usando vectores de objetos
// problema a resolver:
//una tienda de abarrotes necesita un sistema para almacenar y gestionar
 // la informacion de sus productos, incluyendo nombre, precio unitario,
// cantidad en stock y el costo total del inventario por producto.
// estructura de datos:
 // clase producto: encapsula los datos de un producto individual
 // vector de objetos producto para almacenar todos los productos
// clase gestortienda: maneja las operaciones del sistema
// especificaciones:
// moneda utilizada: soles
// capacidad maxima: 50 productos
// precision decimal: 2 decimales para precios y costos

