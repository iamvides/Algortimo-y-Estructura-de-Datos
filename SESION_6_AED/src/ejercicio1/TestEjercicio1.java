package ejercicio1;

import ejercicio1.StackLink;
import actividad1.Stack;
import actividad1.ExceptionIsEmpty;

public class TestEjercicio1 {
    public static void main(String[] args) {
        try {
            Stack<String> pila = new StackLink<>(); // Se usa la interfaz Stack con la implementación StackLink

            pila.push("Arequipa");
            pila.push("Cusco");
            pila.push("Lima");

            System.out.println("Contenido de la pila con lista enlazada:");
            System.out.println(pila); // Imprimir pila

            System.out.println("Elemento en el tope: " + pila.top()); // Mostrar tope actual

            pila.pop(); // Eliminar elemento del tope

            System.out.println("Después de un pop:");
            System.out.println(pila);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
