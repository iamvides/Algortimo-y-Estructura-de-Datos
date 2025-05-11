package actividad1;
public class TestActividad1 {
    public static void main(String[] args) {
        try {
            Stack<Integer> pila = new StackArray<>(5); // Crear pila de enteros

            pila.push(10); // Apilar 10
            pila.push(20); // Apilar 20
            pila.push(30); // Apilar 30

            System.out.println("Contenido de la pila:");
            System.out.println(pila);

            System.out.println("Elemento en el tope: " + pila.top()); // Mostrar tope

            pila.pop(); // Eliminar elemento del tope

            System.out.println("Después de un pop:");
            System.out.println(pila);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}