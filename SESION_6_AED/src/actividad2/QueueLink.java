package actividad2;
import actividad1.ExceptionIsEmpty;

//Implementación de cola usando lista enlazada
public class QueueLink<E> implements Queue<E> {
 private Node<E> primero; // Nodo al frente de la cola
 private Node<E> ultimo; // Nodo al final de la cola

 public QueueLink() {
     this.primero = null; // Inicializa cola vacía
     this.ultimo = null;
 }

 public void enqueue(E x) {
     Node<E> nuevo = new Node<>(x); // Crear nuevo nodo
     if (isEmpty()) {
         primero = nuevo; // Si está vacía, primero apunta al nuevo
     } else {
         ultimo.setSiguiente(nuevo); // Conectar al final
     }
     ultimo = nuevo; // Actualizar último nodo
 }

 public E dequeue() throws ExceptionIsEmpty {
     if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
     E dato = primero.getDato(); // Obtener dato al frente
     primero = primero.getSiguiente(); // Mover puntero al siguiente nodo
     if (primero == null) ultimo = null; // Si quedó vacía, actualizar último
     return dato;
 }

 public E front() throws ExceptionIsEmpty {
     if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
     return primero.getDato(); // Retorna primer elemento
 }

 public E back() throws ExceptionIsEmpty {
     if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
     return ultimo.getDato(); // Retorna último elemento
 }

 public boolean isEmpty() {
     return primero == null; // Verifica si no hay elementos
 }

 public String toString() {
     StringBuilder sb = new StringBuilder(); // Para construir el texto
     Node<E> actual = primero;
     while (actual != null) {
         sb.append(actual.getDato()).append(" -> "); // Agrega cada nodo
         actual = actual.getSiguiente(); // Mover al siguiente
     }
     return sb.append("null").toString(); // Finaliza con null
 }
}