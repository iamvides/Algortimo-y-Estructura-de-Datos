package bstreeLinkedListGeneric;

import java.util.LinkedList;
import java.util.Queue;

import bstreeInterface.BinarySearchTree;
import exceptions.*;

// Clase que representa el árbol binario de búsqueda
public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private Nodo<E> raiz; // raíz del árbol

    public LinkedBST() {
        raiz = null; // árbol empieza vacío
    }

    // insertar elemento en el árbol
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

    // buscar elemento en el árbol
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

    // eliminar un nodo
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

    // recorrido inOrden como texto
    public String inOrden() {
        return recorrerInOrden(raiz).trim();
    }

    private String recorrerInOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return recorrerInOrden(nodo.izq) + nodo.dato + " " + recorrerInOrden(nodo.der);
    }

    public String preOrden() {
        return recorrerPreOrden(raiz).trim();
    }

    private String recorrerPreOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return nodo.dato + " " + recorrerPreOrden(nodo.izq) + recorrerPreOrden(nodo.der);
    }

    public String postOrden() {
        return recorrerPostOrden(raiz).trim();
    }

    private String recorrerPostOrden(Nodo<E> nodo) {
        if (nodo == null) return "";
        return recorrerPostOrden(nodo.izq) + recorrerPostOrden(nodo.der) + nodo.dato + " ";
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

    // destruir todo el árbol
    public void destruirNodos() throws Exception {
        if (raiz == null) throw new Exception("El árbol está vacío");
        raiz = null; // eliminamos referencia a la raíz
    }

    // contar nodos que NO son hojas
    public int contarNodosNoHojas() {
        return contarNodosNoHojas(raiz);
    }

    private int contarNodosNoHojas(Nodo<E> nodo) {
        if (nodo == null) return 0;
        if (nodo.izq == null && nodo.der == null) return 0;
        return 1 + contarNodosNoHojas(nodo.izq) + contarNodosNoHojas(nodo.der);
    }

    // contar TODOS los nodos
    public int contarTodosNodos() {
        return contarTodosNodos(raiz);
    }

    private int contarTodosNodos(Nodo<E> nodo) {
        if (nodo == null) return 0;
        return 1 + contarTodosNodos(nodo.izq) + contarTodosNodos(nodo.der);
    }

    // altura de un subárbol con raíz con dato x (iterativo)
    public int alturaDeSubarbol(E x) {
        Nodo<E> nodo = buscarNodo(raiz, x);
        if (nodo == null) return -1;
        return calcularAltura(nodo);
    }

    private Nodo<E> buscarNodo(Nodo<E> nodo, E x) {
        while (nodo != null) {
            if (x.compareTo(nodo.dato) < 0) nodo = nodo.izq;
            else if (x.compareTo(nodo.dato) > 0) nodo = nodo.der;
            else return nodo;
        }
        return null;
    }

    private int calcularAltura(Nodo<E> nodo) {
        if (nodo == null) return -1;
        Queue<Nodo<E>> cola = new LinkedList<>();
        cola.add(nodo);
        int altura = -1;
        while (!cola.isEmpty()) {
            int tamañoNivel = cola.size();
            for (int i = 0; i < tamañoNivel; i++) {
                Nodo<E> actual = cola.poll();
                if (actual.izq != null) cola.add(actual.izq);
                if (actual.der != null) cola.add(actual.der);
            }
            altura++;
        }
        return altura;
    }

    // amplitud del nivel
    public int amplitudNivel(int nivelObjetivo) {
        if (raiz == null) return 0;
        Queue<Nodo<E>> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 0;
        while (!cola.isEmpty()) {
            int cantidadNivel = cola.size();
            if (nivel == nivelObjetivo) return cantidadNivel;
            for (int i = 0; i < cantidadNivel; i++) {
                Nodo<E> actual = cola.poll();
                if (actual.izq != null) cola.add(actual.izq);
                if (actual.der != null) cola.add(actual.der);
            }
            nivel++;
        }
        return 0;
    }

    // ejercicio 2: contar hojas
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<E> nodo) {
        if (nodo == null) return 0;
        if (nodo.izq == null && nodo.der == null) return 1;
        return contarHojas(nodo.izq) + contarHojas(nodo.der);
    }

    // ejercicio 3: contar nodos con un solo hijo
    public int contarUnHijo() {
        return contarUnHijo(raiz);
    }

    private int contarUnHijo(Nodo<E> nodo) {
        if (nodo == null) return 0;
        int cuenta = 0;
        if ((nodo.izq == null && nodo.der != null) || (nodo.izq != null && nodo.der == null)) {
            cuenta = 1; // este nodo tiene solo un hijo
        }
        return cuenta + contarUnHijo(nodo.izq) + contarUnHijo(nodo.der);
    }
}
