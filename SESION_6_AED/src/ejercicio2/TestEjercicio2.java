package ejercicio2;

import ejercicio2.QueueArray;
import actividad2.Queue;
import actividad1.ExceptionIsEmpty;

public class TestEjercicio2 {
    public static void main(String[] args) {
        try {
            Queue<Integer> cola = new QueueArray<>(4); // Crear cola con capacidad 4

            cola.enqueue(100);
            cola.enqueue(200);
            cola.enqueue(300);

            System.out.println("Contenido de la cola con arreglo:");
            System.out.println(cola);

            System.out.println("Elemento al frente: " + cola.front());
            System.out.println("Elemento al final: " + cola.back());

            cola.dequeue(); // Eliminar uno

            System.out.println("Después de un dequeue:");
            System.out.println(cola);

            cola.enqueue(400); // Insertar más elementos
            cola.enqueue(500); // Debe ignorarse si ya está llena

            System.out.println("Después de insertar más:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}