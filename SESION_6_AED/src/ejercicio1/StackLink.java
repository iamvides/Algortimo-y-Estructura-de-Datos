package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;
import actividad2.Node; // Se usa el mismo Node que en actividad2

// Implementación de una pila usando lista enlazada
public class StackLink<E> implements Stack<E> {
    private Node<E> tope; // Nodo que representa el tope de la pila

    public StackLink() {
        this.tope = null; // Inicialmente la pila está vacía
    }

    @Override
    public void push(E x) {
        Node<E> nuevo = new Node<>(x); // Se crea un nuevo nodo con el dato
        nuevo.setSiguiente(tope); // El siguiente del nuevo nodo es el tope actual
        tope = nuevo; // Ahora el nuevo nodo es el tope
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        E dato = tope.getDato(); // Obtener el dato del tope
        tope = tope.getSiguiente(); // Avanzar al siguiente nodo
        return dato;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return tope.getDato(); // Retorna el dato en el tope
    }

    @Override
    public boolean isEmpty() {
        return tope == null; // Verifica si la pila está vacía
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> actual = tope;
        while (actual != null) {
            sb.append(actual.getDato()).append("\n"); // Agrega los elementos uno por línea
            actual = actual.getSiguiente(); // Avanza al siguiente nodo
        }
        return sb.toString(); // Retorna la representación en texto
    }
}