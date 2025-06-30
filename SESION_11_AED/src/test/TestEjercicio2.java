package test;

import java.util.Scanner;
import hash.HashC;
import hash.Register;

public class TestEjercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashC tabla = new HashC(6); // tamaño 6 según enunciado

        System.out.println("EJERCICIO 2: Colisiones con sondeo lineal");
        System.out.println("Ingrese 4 claves para insertar (usar números como 12, 18, 24, 30):");

        for (int i = 1; i <= 4; i++) {
            System.out.print("Clave " + i + ": ");
            int clave = sc.nextInt();
            Register r = new Register(clave, "Valor" + i);
            tabla.insert(r); // Inserta y ya muestra en qué posición lo colocó
        }

        System.out.println("\nTabla final después de insertar:");
        tabla.printTable();
        sc.close();
    }
}
