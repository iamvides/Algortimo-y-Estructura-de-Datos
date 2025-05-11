package actividad1;
// Implementación de pila usando un arreglo
public class StackArray<E> implements Stack<E> {
    private E[] arreglo; // Arreglo genérico
    private int tope; // Índice del último elemento

    public StackArray(int capacidad) {
        this.arreglo = (E[]) new Object[capacidad]; // Crear arreglo genérico
        this.tope = -1; // Inicializar pila vacía
    }

    public void push(E x) {
        if (isFull()) return; // Si está llena, no insertar
        tope++; // Incrementar tope
        arreglo[tope] = x; // Insertar en el tope
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        E aux = arreglo[tope]; // Guardar elemento del tope
        tope--; // Eliminar elemento del tope
        return aux;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return arreglo[tope]; // Devolver elemento del tope
    }

    public boolean isEmpty() {
        return tope == -1; // Verifica si el tope está en -1
    }

    public boolean isFull() {
        return tope == arreglo.length - 1; // Verifica si el tope alcanzó la capacidad máxima
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Constructor de cadena
        for (int i = tope; i >= 0; i--) {
            sb.append(arreglo[i]).append("\n"); // Mostrar elementos desde el tope
        }
        return sb.toString(); // Retornar cadena
    }
}
