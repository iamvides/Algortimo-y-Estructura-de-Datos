package avltree;

import exceptions.ItemDuplicated;

// Clase base del BST
public class BSTree<E extends Comparable<E>> {
    protected Node<E> raiz;

    public BSTree() {
        raiz = null; // árbol vacío al inicio
    }

    // método básico de inserción (sin balanceo)
    public void insertar(E x) throws ItemDuplicated {
        raiz = insertar(raiz, x);
    }

    protected Node<E> insertar(Node<E> nodo, E x) throws ItemDuplicated {
        if (nodo == null)
            return new Node<>(x);

        if (x.compareTo(nodo.dato) < 0)
            nodo.izq = insertar(nodo.izq, x);
        else if (x.compareTo(nodo.dato) > 0)
            nodo.der = insertar(nodo.der, x);
        else
            throw new ItemDuplicated("Ya existe");

        return nodo;
    }
}