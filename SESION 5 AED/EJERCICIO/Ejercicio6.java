public class Ejercicio6<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static <T> Node<T> concatenarListas(Node<T> lista1, Node<T> lista2) {
        if (lista1 == null) return lista2;

        Node<T> actual = lista1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = lista2;
        return lista1;
    }

    public static void main(String[] args) {
        Node<Integer> lista1 = new Node<>(1);
        lista1.next = new Node<>(2);

        Node<Integer> lista2 = new Node<>(3);
        lista2.next = new Node<>(4);

        Node<Integer> concatenada = concatenarListas(lista1, lista2);

        Node<Integer> actual = concatenada;
        System.out.print("Lista concatenada: ");
        while (actual != null) {
            System.out.print(actual.data + " ");
            actual = actual.next;
        }
    }
}
