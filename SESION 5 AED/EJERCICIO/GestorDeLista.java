import java.util.*;

public class GestorDeLista {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static List<String> lista = new ArrayList<>();

    static Node<String> head = null;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar elemento a lista (ArrayList)");
            System.out.println("2. Buscar elemento (Ejercicio 1)");
            System.out.println("3. Invertir lista (Ejercicio 2)");
            System.out.println("4. Insertar nodo al final (Ejercicio 3)");
            System.out.println("5. Contar nodos (Ejercicio 4)");
            System.out.println("6. Comparar listas (Ejercicio 5)");
            System.out.println("7. Concatenar listas (Ejercicio 6)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarElementoLista();
                case 2 -> buscarElemento();       // Ejercicio 1
                case 3 -> invertirLista();        // Ejercicio 2
                case 4 -> insertarNodoFinal();    // Ejercicio 3
                case 5 -> contarNodos();          // Ejercicio 4
                case 6 -> compararListas();       // Ejercicio 5
                case 7 -> concatenarListas();     // Ejercicio 6
                case 0 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // Ejercicio 1: Buscar elemento
    public static void buscarElemento() {
        System.out.print("Ingrese el valor a buscar: ");
        String valor = scanner.nextLine();
        boolean encontrado = false;
        for (String item : lista) {
            if (item.equals(valor)) {
                encontrado = true;
                break;
            }
        }
        System.out.println(encontrado ? "Elemento encontrado." : "No encontrado.");
    }

    // Ejercicio 2: Invertir lista
    public static void invertirLista() {
        List<String> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        System.out.println("Lista invertida: " + invertida);
    }

    // Ejercicio 3: Insertar nodo al final
    public static void insertarNodoFinal() {
        System.out.print("Ingrese el valor a insertar: ");
        String valor = scanner.nextLine();
        Node<String> nuevo = new Node<>(valor);
        if (head == null) {
            head = nuevo;
        } else {
            Node<String> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevo;
        }
        System.out.println("Insertado correctamente.");
    }

    // Ejercicio 4: Contar nodos
    public static void contarNodos() {
        int count = 0;
        Node<String> actual = head;
        while (actual != null) {
            count++;
            actual = actual.next;
        }
        System.out.println("Cantidad de nodos: " + count);
    }

    // Ejercicio 5: Comparar listas
    public static void compararListas() {
        System.out.println("Creando segunda lista para comparar...");
        Node<String> lista2 = null;
        System.out.print("¿Cuántos nodos tendrá? ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            String val = scanner.nextLine();
            lista2 = insertarAlFinal(lista2, val);
        }

        Node<String> a1 = head;
        Node<String> a2 = lista2;
        boolean iguales = true;
        while (a1 != null && a2 != null) {
            if (!a1.data.equals(a2.data)) {
                iguales = false;
                break;
            }
            a1 = a1.next;
            a2 = a2.next;
        }
        if (a1 != null || a2 != null) iguales = false;

        System.out.println(iguales ? "Las listas son iguales." : "Las listas son diferentes.");
    }

    // Ejercicio 6: Concatenar listas
    public static void concatenarListas() {
        System.out.println("Creando lista a concatenar...");
        Node<String> nueva = null;
        System.out.print("¿Cuántos nodos? ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            String val = scanner.nextLine();
            nueva = insertarAlFinal(nueva, val);
        }

        if (head == null) {
            head = nueva;
        } else {
            Node<String> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nueva;
        }
        System.out.println("Listas concatenadas.");
    }

    public static Node<String> insertarAlFinal(Node<String> head, String valor) {
        Node<String> nuevo = new Node<>(valor);
        if (head == null) return nuevo;
        Node<String> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevo;
        return head;
    }

    public static void agregarElementoLista() {
        System.out.print("Ingrese valor para agregar a la lista genérica: ");
        String valor = scanner.nextLine();
        lista.add(valor);
        System.out.println("Agregado a lista.");
    }
}
