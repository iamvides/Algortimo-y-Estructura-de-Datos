package test;

import btree.BTree;

public class TestEjercicio2 {
    public static void main(String[] args) {
        // Creamos un árbol B de orden 4
        BTree<Integer> arbol = new BTree<>(4);

        // Insertamos los mismos datos del ejemplo de la guía
        int[] datos = {
            31, 12, 19, 3, 10, 13, 16, 22, 25, 28,
            41, 57, 63, 33, 35, 40, 49, 52, 55, 60,
            62, 67, 70, 72
        };

        for (int valor : datos) {
            arbol.insert(valor);
        }

        // Mostrar árbol antes de eliminar
        System.out.println("\nÁrbol antes de eliminar:");
        System.out.println(arbol);

        // PRUEBA DEL EJERCICIO 2: eliminar claves
        System.out.println("\nEliminando 52:");
        arbol.remove(52);

        System.out.println("\nEliminando 62:");
        arbol.remove(62);

        System.out.println("\nEliminando 41:");
        arbol.remove(41);

        System.out.println("\nEliminando 12:");
        arbol.remove(12);

        System.out.println("\nÁrbol después de eliminaciones:");
        System.out.println(arbol);
    }
}
