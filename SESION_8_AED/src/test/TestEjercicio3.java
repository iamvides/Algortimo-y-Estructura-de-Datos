package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestEjercicio3 {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();

            arbol.insertar(50);
            arbol.insertar(30);
            arbol.insertar(70);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(60);
            arbol.insertar(80);

            arbol.imprimir();

            boolean existe = arbol.existeHojaBalanceada();
            System.out.println("¿Existe hoja con bf = 0? " + existe);

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
