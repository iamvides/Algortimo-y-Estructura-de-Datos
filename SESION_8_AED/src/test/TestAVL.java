package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> arbol = new AVLTree<>();

        try {
            // CASO 1: RSR (rotación simple a la derecha)
            System.out.println("CASO 1: RSR");
            arbol.insertar(30);
            arbol.insertar(20);
            arbol.insertar(10); // aquí se debe aplicar RSR
            arbol.imprimir(); // muestra el árbol balanceado
            System.out.println();

            // CASO 2: RSL (rotación simple a la izquierda)
            System.out.println("CASO 2: RSL");
            arbol.insertar(40);
            arbol.insertar(50); // aquí se aplica RSL
            arbol.imprimir();
            System.out.println();

            // CASO 3: RDR (rotación doble a la derecha)
            System.out.println("CASO 3: RDR");
            arbol.insertar(5);
            arbol.insertar(7); // aquí se debe aplicar RDR
            arbol.imprimir();
            System.out.println();

            // CASO 4: RDL (rotación doble a la izquierda)
            System.out.println("CASO 4: RDL");
            arbol.insertar(45);
            arbol.insertar(43); // aquí se aplica RDL
            arbol.imprimir();
            System.out.println();

            // CASO 5: otra RSR
            System.out.println("CASO 5: nueva RSR");
            arbol.insertar(2);
            arbol.insertar(1); // fuerza otra RSR
            arbol.imprimir();
            System.out.println();

            // CASO 6: otra RSL
            System.out.println("CASO 6: nueva RSL");
            arbol.insertar(60);
            arbol.insertar(70); // otra RSL
            arbol.imprimir();
            System.out.println();

            // CASO 7: otra RDR
            System.out.println("CASO 7: nueva RDR");
            arbol.insertar(3);
            arbol.insertar(4); // aplica RDR
            arbol.imprimir();
            System.out.println();

            // CASO 8: otra RDL
            System.out.println("CASO 8: nueva RDL");
            arbol.insertar(65);
            arbol.insertar(63); // aplica RDL
            arbol.imprimir();
            System.out.println();

        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}