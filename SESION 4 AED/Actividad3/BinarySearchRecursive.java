/**
 * Implementación recursiva de búsqueda binaria
 * Complejidad: O(log n)
 */
public class BinarySearchRecursive {
    
    /**
     * Método público para iniciar la búsqueda binaria recursiva
     * @param arr Arreglo ordenado de enteros
     * @param x Elemento a buscar
     * @return Índice del elemento o -1 si no se encuentra
     */
    public static int binarySearch(int[] arr, int x) {
        return binarySearch(arr, x, 0, arr.length - 1);
    }
    
    /**
     * Método recursivo privado
     * @param arr Arreglo ordenado
     * @param x Elemento a buscar
     * @param left Límite inferior
     * @param right Límite superior
     * @return Índice del elemento o -1 si no se encuentra
     */
    private static int binarySearch(int[] arr, int x, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return binarySearch(arr, x, mid + 1, right);
        } else {
            return binarySearch(arr, x, left, mid - 1);
        }
    }
}