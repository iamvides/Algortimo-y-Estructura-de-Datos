package actividad1;
// Interfaz genérica para pila
public interface Stack<E> {
    void push(E x); // Apila un elemento
    E pop() throws ExceptionIsEmpty; // Desapila el elemento del tope
    E top() throws ExceptionIsEmpty; // Devuelve el elemento del tope
    boolean isEmpty(); // Verifica si la pila está vacía
}