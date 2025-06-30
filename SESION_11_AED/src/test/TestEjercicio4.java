package test;

import hash.HashC;
import hash.Register;

public class TestEjercicio4 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 4: Eliminar en hash cerrado con sondeo lineal");

        HashC tabla = new HashC(7);

        // Insertamos los registros
        tabla.insert(new Register(5, "Uno"));
        tabla.insert(new Register(12, "Dos"));
        tabla.insert(new Register(19, "Tres"));

        tabla.printTable();

        // Eliminamos la clave 12
        System.out.println("\nEliminando la clave 12...");
        tabla.delete(12);

        tabla.printTable();

        // Verificamos que aún se puede encontrar la clave 19
        System.out.println("\nBuscando la clave 19...");
        Register resultado = tabla.search(19);
        if (resultado != null) {
            System.out.println("Resultado: " + resultado.getName());
        } else {
            System.out.println("Resultado: No encontrado");
        }
    }
}
