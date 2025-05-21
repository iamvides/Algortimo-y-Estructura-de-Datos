package bstreeLinkedListGeneric;

// Clase Nodo genérico para el árbol
public class Nodo<E> {
    E dato;              // valor que guarda
    Nodo<E> izq;         // hijo izquierdo
    Nodo<E> der;         // hijo derecho

    public Nodo(E dato) {
        this.dato = dato; // se asigna el dato
        this.izq = null;  // hijo izq vacío
        this.der = null;  // hijo der vacío
    }
}
