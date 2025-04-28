import java.util.List;

public class Ejercicio1 {
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> palabras = List.of("hola", "mundo", "java");
        boolean existe = buscarElemento(palabras, "mundo");
        System.out.println("¿Existe 'mundo'? " + existe); // true

        boolean noExiste = buscarElemento(palabras, "python");
        System.out.println("¿Existe 'python'? " + noExiste); // false
    }
}