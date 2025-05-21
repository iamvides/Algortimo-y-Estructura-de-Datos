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
            System.out.println("PreOrden: " + arbol.preOrden());
            System.out.println("PostOrden: " + arbol.postOrden());

            System.out.println("Mínimo: " + arbol.obtenerMinimo());
            System.out.println("Máximo: " + arbol.obtenerMaximo());

            System.out.println("Altura del subárbol con raíz 5: " + arbol.alturaDeSubarbol(5));
            System.out.println("Amplitud del nivel 2: " + arbol.amplitudNivel(2));

            System.out.println("Total de nodos: " + arbol.contarTodosNodos());
            System.out.println("Nodos no-hoja: " + arbol.contarNodosNoHojas());

            arbol.destruirNodos();
            System.out.println("Árbol destruido.");
            System.out.println("Total después de destruir: " + arbol.contarTodosNodos());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}