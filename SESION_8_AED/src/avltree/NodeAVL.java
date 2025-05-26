package avltree;

// Nodo AVL que hereda de Node
public class NodeAVL<E> extends Node<E> {
    int bf; // factor de equilibrio

    public NodeAVL(E dato) {
        super(dato);  // llama al constructor de Node
        this.bf = 0;  // al inicio está balanceado
    }

    @Override
    public String toString() {
        return dato + "(bf=" + bf + ")"; // muestra el dato y su factor de equilibrio
    }
}
