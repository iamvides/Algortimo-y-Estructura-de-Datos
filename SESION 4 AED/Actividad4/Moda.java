import java.util.Arrays;

/**
 * Clase para calcular la moda usando Divide y Vencerás
 * Complejidad: O(n log n) por el sorting inicial
 */
public class Moda {

    /**
     * Encuentra la moda en un arreglo de enteros
     * @param arr Arreglo de enteros (no necesariamente ordenado)
     * @return El valor que más se repite (moda)
     */
    public static int encontrarModa(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo o vacío");
        }

        // Paso 1: Ordenar el arreglo (requisito para el algoritmo eficiente)
        Arrays.sort(arr);

        // Paso 2: Buscar la moda en el arreglo ordenado
        return modaOrdenado(arr);
    }

    /**
     * Método auxiliar para encontrar moda en arreglo ordenado
     * Complejidad: O(n)
     */
    private static int modaOrdenado(int[] arr) {
        int moda = arr[0];
        int maxFrecuencia = 1;
        int frecuenciaActual = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > maxFrecuencia) {
                    maxFrecuencia = frecuenciaActual;
                    moda = arr[i - 1];
                }
                frecuenciaActual = 1;
            }
        }

        // Verificar la última secuencia
        if (frecuenciaActual > maxFrecuencia) {
            moda = arr[arr.length - 1];
        }

        return moda;
    }
}