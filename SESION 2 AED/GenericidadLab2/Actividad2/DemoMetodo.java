package GenericidadLab2.Actividad2;
public class DemoMetodo {
    // Método genérico que compara dos arreglos
    public static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si las longitudes de los arrays son diferentes, los arrays son distintos
        if (x.length != y.length)
            return false;
        // Comparar elemento por elemento
        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i]))
                return false; // Arrays diferentes
        }
        return true; // Contenido de los arrays es equivalente
    }
}