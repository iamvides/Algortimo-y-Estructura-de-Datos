package ejercicio2;

import actividad2.Queue;
import actividad1.ExceptionIsEmpty;

// Implementación de una cola con arreglo circular
public class QueueArray<E> implements Queue<E> {
    private E[] arreglo; // Arreglo genérico para almacenar los elementos
    private int first; // Índice del primer elemento
    private int last; // Índice del último elemento insertado
    private int size; // Cantidad actual de elementos

    public QueueArray(int capacidad) {
        this.arreglo = (E[]) new Object[capacidad]; // Crear arreglo con capacidad dada
        this.first = 0; // El frente empieza en 0
        this.last = -1; // El último empieza antes del inicio
        this.size = 0; // Inicialmente está vacía
    }

    @Override
    public void enqueue(E x) {
        if (isFull()) return; // Si está llena, no se puede insertar

        last = (last + 1) % arreglo.length; // Avanzar el índice circularmente
        arreglo[last] = x; // Insertar en la posición calculada
        size++; // Aumentar tamaño
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");

        E aux = arreglo[first]; // Obtener el elemento al frente
        first = (first + 1) % arreglo.length; // Avanzar el frente circularmente
        size--; // Disminuir el tamaño
        return aux;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return arreglo[first]; // Retornar el primer elemento
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return arreglo[last]; // Retornar el último elemento insertado
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // Verifica si hay 0 elementos
    }

    public boolean isFull() {
        return size == arreglo.length; // Verifica si está llena
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        int index = first;
        while (contador < size) {
            sb.append(arreglo[index]).append(" -> ");
            index = (index + 1) % arreglo.length;
            contador++;
        }
        return sb.append("null").toString();
    }
}
