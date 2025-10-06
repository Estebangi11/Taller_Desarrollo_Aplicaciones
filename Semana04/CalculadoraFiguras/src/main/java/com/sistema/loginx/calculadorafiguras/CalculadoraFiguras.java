/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistema.loginx.calculadorafiguras;
import java.util.Scanner;

public class CalculadoraFiguras {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== CALCULADORA DE FIGURAS GEOMÉTRICAS ===");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Triángulo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción (1-4): ");
            opcion = sc.nextInt();
            
            switch(opcion) {
                case 1:
                    calcularCuadrado(sc);
                    break;
                case 2:
                    calcularRectangulo(sc);
                    break;
                case 3:
                    calcularTriangulo(sc);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while(opcion != 4);
        
        sc.close();
    }
    
    public static void calcularCuadrado(Scanner sc) {
        System.out.print("\nIngresa el lado del cuadrado: ");
        double lado = sc.nextDouble();
        
        double area = lado * lado;
        double perimetro = 4 * lado;
        
        System.out.println("\n--- RESULTADOS DEL CUADRADO ---");
        System.out.printf("Área: %.2f unidades cuadradas\n", area);
        System.out.printf("Perímetro: %.2f unidades\n", perimetro);
    }
    
    public static void calcularRectangulo(Scanner sc) {
        System.out.print("\nIngresa la base del rectángulo: ");
        double base = sc.nextDouble();
        System.out.print("Ingresa la altura del rectángulo: ");
        double altura = sc.nextDouble();
        
        double area = base * altura;
        double perimetro = 2 * (base + altura);
        
        System.out.println("\n--- RESULTADOS DEL RECTÁNGULO ---");
        System.out.printf("Área: %.2f unidades cuadradas\n", area);
        System.out.printf("Perímetro: %.2f unidades\n", perimetro);
    }
    
    public static void calcularTriangulo(Scanner sc) {
        System.out.print("\nIngresa la base del triángulo: ");
        double base = sc.nextDouble();
        System.out.print("Ingresa la altura del triángulo: ");
        double altura = sc.nextDouble();
        System.out.print("Ingresa el lado 1: ");
        double lado1 = sc.nextDouble();
        System.out.print("Ingresa el lado 2: ");
        double lado2 = sc.nextDouble();
        
        double area = (base * altura) / 2;
        double perimetro = base + lado1 + lado2;
        
        System.out.println("\n--- RESULTADOS DEL TRIÁNGULO ---");
        System.out.printf("Área: %.2f unidades cuadradas\n", area);
        System.out.printf("Perímetro: %.2f unidades\n", perimetro);
    }
}