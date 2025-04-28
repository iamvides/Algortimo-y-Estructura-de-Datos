import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        List<Integer> invertidos = invertirLista(numeros);
        System.out.println("Lista invertida: " + invertidos);
    }
}
