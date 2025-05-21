package test;

import bstreeLinkedListGeneric.LinkedBST;
import exceptions.*;

public class Prueba {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> arbol = new LinkedBST<>();

            arbol.insertar(10);
            arbol.insertar(5);
            arbol.insertar(15);
            arbol.insertar(3);
            arbol.insertar(7);
            arbol.insertar(12);
            arbol.insertar(18);

            System.out.println("InOrden: " + arbol.inOrden());
            System.out.println("Total de nodos: " + arbol.contarTodosNodos());
            System.out.println("Nodos no-hoja: " + arbol.contarNodosNoHojas());
            System.out.println("Cantidad de hojas: " + arbol.contarHojas()); // ejercicio 2

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}