package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio1 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(30);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(10);
            arbol.insertar(25);
            arbol.insertar(35);
            arbol.insertar(50);

            arbol.imprimir();

            int totalBalanceados = arbol.contarBalanceados();
            System.out.println("Nodos con bf = 0: " + totalBalanceados);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
