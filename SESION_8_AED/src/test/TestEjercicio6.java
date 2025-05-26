package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio6 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(60);
            arbol.insertar(40);
            arbol.insertar(80);
            arbol.insertar(30);
            arbol.insertar(50);
            arbol.insertar(70);
            arbol.insertar(90);

            arbol.imprimir();

            int internos = arbol.contarNodosInternos();
            System.out.println("Cantidad de nodos internos: " + internos);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}