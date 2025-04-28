import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioTareas<T> {
    private Nodo<T> cabeza;
    private List<T> tareasCompletadas;
    private Scanner scanner;

    public ServicioTareas() {
        this.cabeza = null;
        this.tareasCompletadas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n==== Menú Gestor de Tareas ====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Verificar existencia de tarea");
            System.out.println("4. Mostrar todas las tareas");
            System.out.println("5. Contar tareas pendientes");
            System.out.println("6. Invertir lista de tareas");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Mostrar tareas completadas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    eliminarTarea();
                    break;
                case 3:
                    verificarTarea();
                    break;
                case 4:
                    mostrarTareas();
                    break;
                case 5:
                    System.out.println("Total tareas pendientes: " + contarTareas());
                    break;
                case 6:
                    invertirLista();
                    System.out.println("Lista de tareas invertida");
                    break;
                case 7:
                    marcarComoCompletada();
                    break;
                case 8:
                    mostrarTareasCompletadas();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void agregarTarea() {
        System.out.print("Ingrese la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la prioridad (número): ");
        int prioridad = scanner.nextInt();
        
        T nuevaTarea = (T) new Tarea(descripcion, prioridad);
        agregarTareaAlFinal(nuevaTarea);
        System.out.println("Tarea agregada exitosamente");
    }

    private void agregarTareaAlFinal(T tarea) {
        Nodo<T> nuevoNodo = new Nodo<>(tarea);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    private void eliminarTarea() {
        System.out.print("Ingrese la descripción de la tarea a eliminar: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la prioridad: ");
        int prioridad = scanner.nextInt();
        
        T tareaAEliminar = (T) new Tarea(descripcion, prioridad);
        if (eliminarTareaDeLista(tareaAEliminar)) {
            System.out.println("Tarea eliminada exitosamente");
        } else {
            System.out.println("Tarea no encontrada");
        }
    }

    private boolean eliminarTareaDeLista(T tarea) {
        if (cabeza == null) return false;

        if (cabeza.getDato().equals(tarea)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(tarea)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            return true;
        }
        return false;
    }

    private void verificarTarea() {
        System.out.print("Ingrese la descripción de la tarea a verificar: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la prioridad: ");
        int prioridad = scanner.nextInt();
        
        T tareaABuscar = (T) new Tarea(descripcion, prioridad);
        if (contieneTarea(tareaABuscar)) {
            System.out.println("La tarea existe en la lista");
        } else {
            System.out.println("La tarea NO existe en la lista");
        }
    }

    private boolean contieneTarea(T tarea) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(tarea)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    private void mostrarTareas() {
        System.out.println("\n=== Tareas Pendientes ===");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    private int contarTareas() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    private void invertirLista() {
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }

    private void marcarComoCompletada() {
        System.out.print("Ingrese la descripción de la tarea completada: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la prioridad: ");
        int prioridad = scanner.nextInt();
        
        T tareaACompletar = (T) new Tarea(descripcion, prioridad);
        if (transferirATareasCompletadas(tareaACompletar)) {
            System.out.println("Tarea marcada como completada");
        } else {
            System.out.println("Tarea no encontrada");
        }
    }

    private boolean transferirATareasCompletadas(T tarea) {
        if (eliminarTareaDeLista(tarea)) {
            tareasCompletadas.add(tarea);
            return true;
        }
        return false;
    }

    private void mostrarTareasCompletadas() {
        System.out.println("\n=== Tareas Completadas ===");
        for (T tarea : tareasCompletadas) {
            System.out.println(tarea);
        }
    }
}