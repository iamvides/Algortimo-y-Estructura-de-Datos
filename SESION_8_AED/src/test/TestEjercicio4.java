package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio4 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(100);
            arbol.insertar(50);
            arbol.insertar(150);
            arbol.insertar(25);
            arbol.insertar(75);
            arbol.insertar(125);
            arbol.insertar(175);

            arbol.imprimir();

            int conDosHijos = arbol.contarNodosConDosHijos();
            System.out.println("Nodos con dos hijos: " + conDosHijos);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
