package avltree;

// Clase nodo base del BST
public class Node<E> {
    protected E dato;           // el dato guardado
    protected Node<E> izq;      // hijo izquierdo
    protected Node<E> der;      // hijo derecho

    public Node(E dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
}