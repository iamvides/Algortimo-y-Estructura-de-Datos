package test;

import btree.BTree;

public class TestEjercicio1 {
    public static void main(String[] args) {
        // Creamos un árbol B de orden 4
        BTree<Integer> arbol = new BTree<>(4);

        // Insertamos algunos datos
        int[] datos = {
        		100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93,94
        };

        for (int valor : datos) {
            arbol.insert(valor);
        }

        // PRUEBA DEL EJERCICIO 1: buscar clave 52
        System.out.println("\nProbando búsqueda de 52:");
        boolean existe = arbol.search(80);
        System.out.println("Resultado: " + existe);

        // PRUEBA ADICIONAL: buscar clave que no existe
        System.out.println("\nProbando búsqueda de 1000:");
        boolean existe2 = arbol.search(1000);
        System.out.println("Resultado: " + existe2);
    }
}