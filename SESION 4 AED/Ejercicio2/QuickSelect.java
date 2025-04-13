import java.util.Random;

public class QuickSelect {

    private static final Random rand = new Random();

    /**
     * Encuentra el k-ésimo elemento más pequeño en un arreglo
     * @param arr Arreglo de enteros
     * @param k Índice del elemento buscado (1-based)
     * @return El k-ésimo elemento más pequeño
     */
    public static int findKthSmallest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Parámetros inválidos");
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1); // Convertimos a 0-based
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        // Selección aleatoria de pivote para mejor rendimiento promedio
        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right); // Movemos el pivote al final
        
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        
        swap(arr, right, storeIndex); // Movemos el pivote a su posición final
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}