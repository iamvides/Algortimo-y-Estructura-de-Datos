package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio2 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(10);
            arbol.insertar(5);
            arbol.insertar(15);
            arbol.insertar(3);
            arbol.insertar(8);
            arbol.insertar(12);
            arbol.insertar(20);

            arbol.imprimir();

            int suma = arbol.sumarNoBalanceados();
            System.out.println("Suma de nodos con bf ≠ 0: " + suma);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
