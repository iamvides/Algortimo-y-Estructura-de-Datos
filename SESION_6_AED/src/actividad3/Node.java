package actividad3;

//Clase nodo genérico para lista enlazada
public class Node<E> {
 private E dato; // Dato almacenado en el nodo
 private Node<E> siguiente; // Enlace al siguiente nodo

 public Node(E dato) {
     this.dato = dato; // Se asigna el dato al nodo
     this.siguiente = null; // El siguiente es nulo al inicio
 }

 public E getDato() {
     return dato; // Devuelve el dato del nodo
 }

 public void setDato(E dato) {
     this.dato = dato; // Cambia el dato del nodo
 }

 public Node<E> getSiguiente() {
     return siguiente; // Devuelve el nodo siguiente
 }

 public void setSiguiente(Node<E> siguiente) {
     this.siguiente = siguiente; // Establece el nodo siguiente
 }
}