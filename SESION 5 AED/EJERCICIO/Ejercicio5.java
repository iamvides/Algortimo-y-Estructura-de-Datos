public class Ejercicio5<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static <T> boolean sonIguales(Node<T> lista1, Node<T> lista2) {
        Node<T> actual1 = lista1;
        Node<T> actual2 = lista2;

        while (actual1 != null && actual2 != null) {
            if (!actual1.data.equals(actual2.data)) {
                return false;
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }
        return actual1 == null && actual2 == null;
    }

    public static void main(String[] args) {
        Node<Integer> lista1 = new Node<>(1);
        lista1.next = new Node<>(2);
        lista1.next.next = new Node<>(3);

        Node<Integer> lista2 = new Node<>(1);
        lista2.next = new Node<>(2);
        lista2.next.next = new Node<>(3);

        Node<Integer> lista3 = new Node<>(1);
        lista3.next = new Node<>(2);

        System.out.println("¿Lista1 y Lista2 son iguales? " + sonIguales(lista1, lista2)); // true
        System.out.println("¿Lista1 y Lista3 son iguales? " + sonIguales(lista1, lista3)); // false
    }
}
