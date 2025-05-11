package actividad3;
import actividad1.ExceptionIsEmpty;

//Interfaz genérica para cola de prioridad
public interface PriorityQueue<E, N extends Comparable<N>> {
 void enqueue(E x, N prioridad); // Encolar con prioridad
 E dequeue() throws ExceptionIsEmpty; // Desencolar elemento de mayor prioridad
 E front() throws ExceptionIsEmpty; // Ver elemento de mayor prioridad
 E back() throws ExceptionIsEmpty; // Ver elemento de menor prioridad
 boolean isEmpty(); // Verificar si está vacía
}