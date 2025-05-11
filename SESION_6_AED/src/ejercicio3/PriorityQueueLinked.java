package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;
import actividad3.PriorityQueue;

// Cola de prioridad con múltiples colas internas (una por prioridad)
public class PriorityQueueLinked<E> implements PriorityQueue<E, Integer> {

    private QueueLink<E>[] colas; // Arreglo de colas (una por prioridad)
    private int niveles; // Cantidad de niveles de prioridad

    public PriorityQueueLinked(int niveles) {
        this.niveles = niveles;
        colas = new QueueLink[niveles]; // Se crea el arreglo

        for (int i = 0; i < niveles; i++) {
            colas[i] = new QueueLink<>(); // Se inicializa cada cola
        }
    }

    @Override
    public void enqueue(E x, Integer prioridad) {
        if (prioridad < 0 || prioridad >= niveles) return; // Verifica rango válido
        colas[prioridad].enqueue(x); // Encola en la cola correspondiente
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) { // De mayor a menor prioridad
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue(); // Desencolar el primero disponible
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return colas[i].front(); // Devuelve el frente de la prioridad más alta
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].back(); // Devuelve el final de la prioridad más baja
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public boolean isEmpty() {
        for (QueueLink<E> cola : colas) {
            if (!cola.isEmpty()) return false; // Si alguna cola tiene elementos, no está vacía
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cola de prioridad:\n");
        for (int i = niveles - 1; i >= 0; i--) {
            sb.append("Prioridad ").append(i).append(": ");
            sb.append(colas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
