package actividad3;
import actividad1.ExceptionIsEmpty;
import actividad2.Node;

// Implementación de la cola de prioridad con lista enlazada ordenada
public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    // Clase interna para encapsular dato y prioridad
    class Entrada {
        E dato; // Dato genérico
        N prioridad; // Prioridad

        Entrada(E dato, N prioridad) {
            this.dato = dato;
            this.prioridad = prioridad;
        }
    }

    private Node<Entrada> primero; // Nodo al frente
    private Node<Entrada> ultimo;  // Nodo al final

    public PriorityQueueLinkSort() {
        this.primero = null; // Cola vacía
        this.ultimo = null;
    }

    public void enqueue(E x, N pr) {
        Entrada nuevaEntrada = new Entrada(x, pr); // Crear nueva entrada
        Node<Entrada> nuevoNodo = new Node<>(nuevaEntrada); // Nodo con la entrada

        if (isEmpty()) {
            primero = ultimo = nuevoNodo; // Si está vacía, primero y último apuntan al nuevo nodo
        } else if (pr.compareTo(primero.getDato().prioridad) > 0) {
            // Si la prioridad es mayor que el primero, insertar al inicio
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        } else {
            // Buscar la posición para insertar según prioridad
            Node<Entrada> actual = primero;
            while (actual.getSiguiente() != null &&
                   pr.compareTo(actual.getSiguiente().getDato().prioridad) <= 0) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente()); // Insertar en la posición correcta
            actual.setSiguiente(nuevoNodo);
            if (nuevoNodo.getSiguiente() == null) {
                ultimo = nuevoNodo; // Actualizar último si se insertó al final
            }
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E dato = primero.getDato().dato; // Obtener el dato del primero
        primero = primero.getSiguiente(); // Avanzar al siguiente nodo
        if (primero == null) ultimo = null; // Si quedó vacía, actualizar último
        return dato;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return primero.getDato().dato; // Devolver el dato con mayor prioridad
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return ultimo.getDato().dato; // Devolver el dato con menor prioridad
    }

    public boolean isEmpty() {
        return primero == null; // Verificar si está vacía
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Construir representación
        Node<Entrada> actual = primero;
        while (actual != null) {
            sb.append("(").append(actual.getDato().dato)
              .append(", prioridad=").append(actual.getDato().prioridad).append(") -> ");
            actual = actual.getSiguiente();
        }
        return sb.append("null").toString(); // Terminar con null
    }
}