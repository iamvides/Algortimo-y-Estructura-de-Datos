package actividad2;
import actividad1.ExceptionIsEmpty;

//Interfaz genérica para cola
public interface Queue<E> {
 void enqueue(E x); // Encolar elemento
 E dequeue() throws ExceptionIsEmpty; // Desencolar elemento
 E front() throws ExceptionIsEmpty; // Obtener primer elemento
 E back() throws ExceptionIsEmpty; // Obtener último elemento
 boolean isEmpty(); // Verificar si está vacía
}
