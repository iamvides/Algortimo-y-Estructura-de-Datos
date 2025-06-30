package test;

import hash.HashO;
import hash.Register;

public class TestEjercicio3 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 3: Buscar en hash abierto (encadenamiento)");

        HashO tabla = new HashO(5); // Tamaño de la tabla: 5

        // Insertamos los elementos indicados
        tabla.insert(new Register(10, "Juan"));   // h(10) = 0
        tabla.insert(new Register(15, "Ana"));    // h(15) = 0 → colisión con 10
        tabla.insert(new Register(20, "Luis"));   // h(20) = 0 → colisión
        tabla.insert(new Register(25, "Rosa"));   // h(25) = 0 → colisión

        // Mostramos la tabla hash
        tabla.printTable();

        // 1. Buscar la clave 20 (esperado: Luis)
        System.out.println("\nBuscando clave 20:");
        Register resultado = tabla.search(20);
        if (resultado != null) {
            System.out.println("Resultado: " + resultado.getName());
        }

        // 2. Buscar la clave 30 (esperado: no encontrado)
        System.out.println("\nBuscando clave 30:");
        Register resultado2 = tabla.search(30);
        if (resultado2 == null) {
            System.out.println("Resultado: No encontrado");
        }
    }
}
