package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio5 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(40);
            arbol.insertar(20);
            arbol.insertar(60);
            arbol.insertar(10);
            arbol.insertar(30);
            arbol.insertar(50);
            arbol.insertar(70);

            arbol.imprimir();

            int sumaHojas = arbol.sumarHojas();
            System.out.println("Suma de nodos hoja: " + sumaHojas);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
