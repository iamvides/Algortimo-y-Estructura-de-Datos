/**
 * Implementación iterativa de búsqueda binaria
 * Complejidad: O(log n)
 */
public class BinarySearchIterative {
    
    /**
     * Busca un elemento en un arreglo ordenado
     * @param arr Arreglo ordenado de enteros
     * @param x Elemento a buscar
     * @return Índice del elemento o -1 si no se encuentra
     */
    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}