package actividad2;

//Clase nodo genérico para lista enlazada
public class Node<E> {
 private E dato; // Dato que almacena el nodo
 private Node<E> siguiente; // Enlace al siguiente nodo

 public Node(E dato) {
     this.dato = dato; // Inicializa el dato
     this.siguiente = null; // Siguiente es nulo al inicio
 }

 public E getDato() { return dato; } // Retorna el dato
 public void setDato(E dato) { this.dato = dato; } // Modifica el dato

 public Node<E> getSiguiente() { return siguiente; } // Retorna el siguiente nodo
 public void setSiguiente(Node<E> siguiente) { this.siguiente = siguiente; } // Modifica el siguiente nodo
}