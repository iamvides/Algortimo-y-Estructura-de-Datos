package actividad3;
import actividad3.*;
import actividad1.ExceptionIsEmpty;

public class TestActividad3 {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

            cola.enqueue("Tarea urgente", 3);
            cola.enqueue("Tarea media", 2);
            cola.enqueue("Tarea baja", 1);
            cola.enqueue("Tarea crítica", 5);

            System.out.println("Contenido de la cola de prioridad:");
            System.out.println(cola);

            System.out.println("Elemento de mayor prioridad: " + cola.front());
            System.out.println("Elemento de menor prioridad: " + cola.back());

            cola.dequeue();

            System.out.println("Después de un dequeue:");
            System.out.println(cola);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}