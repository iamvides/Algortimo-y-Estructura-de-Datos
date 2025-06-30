package test;

import java.util.Scanner;
import hash.HashC;
import hash.Register;

public class TestEjercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashC tabla = new HashC(7); // Tabla hash de tamaño 7

        System.out.println("EJERCICIO 1: Inserción sin colisiones (intente evitar duplicados)");
        System.out.println("Ingrese 4 claves enteras a insertar:");

        for (int i = 1; i <= 4; i++) {
            System.out.print("Clave " + i + ": ");
            int clave = sc.nextInt();
            Register r = new Register(clave, "Valor" + i);
            tabla.insert(r);
        }

        tabla.printTable();
        sc.close();
    }
}