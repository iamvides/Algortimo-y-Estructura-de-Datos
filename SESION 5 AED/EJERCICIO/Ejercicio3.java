public class Ejercicio3<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
        if (head == null) return nuevoNodo;

        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevoNodo;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head = insertarAlFinal(head, 2);
        head = insertarAlFinal(head, 3);

        Node<Integer> actual = head;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.data + " ");
            actual = actual.next;
        }
    }
}
