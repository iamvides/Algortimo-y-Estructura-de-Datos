package bstreeLinkedListGeneric;

import bstreeInterface.BinarySearchTree;
import exceptions.*;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private Nodo<E> raiz; // raíz del árbol

    public LinkedBST() {
        raiz = null; // árbol vacío al inicio
    }

    public void insertar(E dato) throws ItemDuplicated {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo<E> insertarRec(Nodo<E> nodo, E dato) throws ItemDuplicated {
        if (nodo == null) return new Nodo<>(dato);
        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izq = insertarRec(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.der = insertarRec(nodo.der, dato);
        } else {
            throw new ItemDuplicated("Elemento duplicado");
        }
        return nodo;
    }

    public E buscar(E dato) throws ItemNotFound {
        return buscarRec(raiz, dato);
    }

    private E buscarRec(Nodo<E> nodo, E dato) throws ItemNotFound {
        if (nodo == null) throw new ItemNotFound("Elemento no encontrado");
        if (dato.compareTo(nodo.dato) < 0) {
            return buscarRec(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            return buscarRec(nodo.der, dato);
        } else {
            return nodo.dato;
        }
    }

    public void eliminar(E dato) throws ExceptionIsEmpty {
        if (raiz == null) throw new ExceptionIsEmpty("Árbol vacío");
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo<E> eliminarRec(Nodo<E> nodo, E dato) {
        if (nodo == null) return null;

        if (dato.compareTo(nodo.dato) < 0) {
            nodo.izq = eliminarRec(nodo.izq, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.der = eliminarRec(nodo.der, dato);
        } else {
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;
            nodo.dato = encontrarMin(nodo.der);
            nodo.der = eliminarRec(nodo.der, nodo.dato);
        }
        return nodo;
    }

    private E encontrarMin(Nodo<E> nodo) {
        while (nodo.izq != null) nodo = nodo.izq;
        return nodo.dato;
    }

    public String toString() {
        return recorrerInOrden(raiz).trim();
    }

    private String recorrerInOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return recorrerInOrden(nodo.izq) + nodo.dato + " " + recorrerInOrden(nodo.der);
    }

    private String recorrerPreOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return nodo.dato + " " + recorrerPreOrden(nodo.izq) + recorrerPreOrden(nodo.der);
    }

    private String recorrerPostOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return recorrerPostOrden(nodo.izq) + recorrerPostOrden(nodo.der) + nodo.dato + " ";
    }

    public String inOrden() {
        return recorrerInOrden(raiz).trim();
    }

    public String preOrden() {
        return recorrerPreOrden(raiz).trim();
    }

    public String postOrden() {
        return recorrerPostOrden(raiz).trim();
    }

    public E obtenerMinimo() throws ItemNotFound {
        if (raiz == null) throw new ItemNotFound("Árbol vacío");
        Nodo<E> actual = raiz;
        while (actual.izq != null) actual = actual.izq;
        return actual.dato;
    }

    public E obtenerMaximo() throws ItemNotFound {
        if (raiz == null) throw new ItemNotFound("Árbol vacío");
        Nodo<E> actual = raiz;
        while (actual.der != null) actual = actual.der;
        return actual.dato;
    }
}
