package ejercicio3;
import ejercicio3.PriorityQueueLinked;
import actividad3.PriorityQueue;
import actividad1.ExceptionIsEmpty;

public class TestEjercicio3 {
    public static void main(String[] args) {
        try {
            // Crear cola de prioridad con 4 niveles (0 a 3)
            PriorityQueue<String, Integer> cola = new PriorityQueueLinked<>(4);

            cola.enqueue("Solicitud baja", 0);
            cola.enqueue("Solicitud media", 1);
            cola.enqueue("Solicitud alta", 2);
            cola.enqueue("Solicitud crítica", 3);

            System.out.println("Contenido inicial:");
            System.out.println(cola);

            System.out.println("Frente: " + cola.front()); // Debe ser "Solicitud crítica"
            System.out.println("Final: " + cola.back());   // Debe ser "Solicitud baja"

            cola.dequeue(); // Elimina "Solicitud crítica"

            System.out.println("Después de un dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
