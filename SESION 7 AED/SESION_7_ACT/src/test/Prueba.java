package test;

import bstreeLinkedListGeneric.LinkedBST;
import exceptions.*;

public class Prueba {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> arbol = new LinkedBST<>();

            arbol.insertar(8);
            arbol.insertar(3);
            arbol.insertar(10);
            arbol.insertar(1);
            arbol.insertar(6);
            arbol.insertar(14);

            System.out.println("InOrden: " + arbol.inOrden());
            System.out.println("PreOrden: " + arbol.preOrden());
            System.out.println("PostOrden: " + arbol.postOrden());

            System.out.println("Mínimo: " + arbol.obtenerMinimo());
            System.out.println("Máximo: " + arbol.obtenerMaximo());

            arbol.eliminar(6);
            System.out.println("Después de eliminar 6: " + arbol.inOrden());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}