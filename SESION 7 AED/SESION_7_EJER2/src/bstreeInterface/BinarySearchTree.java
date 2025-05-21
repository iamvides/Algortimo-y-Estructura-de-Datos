package bstreeInterface;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insertar(E dato) throws exceptions.ItemDuplicated;
    E buscar(E dato) throws exceptions.ItemNotFound;
    void eliminar(E dato) throws exceptions.ExceptionIsEmpty;
    String toString();
}