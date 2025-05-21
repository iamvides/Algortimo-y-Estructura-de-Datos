package bstreeLinkedListGeneric;

public class Nodo<E> {
    E dato;
    Nodo<E> izq;
    Nodo<E> der;

    public Nodo(E dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
}