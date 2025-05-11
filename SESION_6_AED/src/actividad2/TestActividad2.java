package actividad2;

import actividad1.ExceptionIsEmpty;

public class TestActividad2 {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueLink<>(); // Crear cola de Strings

            cola.enqueue("Juan");
            cola.enqueue("María");
            cola.enqueue("Carlos");

            System.out.println("Contenido de la cola:");
            System.out.println(cola); // Imprimir cola

            System.out.println("Elemento al frente: " + cola.front()); // Mostrar frente
            System.out.println("Elemento al final: " + cola.back());   // Mostrar último

            cola.dequeue(); // Desencolar un elemento

            System.out.println("Después de un dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}