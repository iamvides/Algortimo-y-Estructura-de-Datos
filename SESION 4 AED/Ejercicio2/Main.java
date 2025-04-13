public class Main {
    public static void main(String[] args) {
        // Casos de prueba del enunciado
        int[] arr1 = {4, 2, 7, 10, 4, 17};
        System.out.println("3er elemento más pequeño en [4,2,7,10,4,17]: " + 
                         QuickSelect.findKthSmallest(arr1, 3));
        
        int[] arr2 = {4, 2, 7, 10, 4, 1, 6};
        System.out.println("5to elemento más pequeño en [4,2,7,10,4,1,6]: " + 
                         QuickSelect.findKthSmallest(arr2, 5));
        
        // Caso adicional
        int[] arr3 = {9, 5, 3, 1, 6, 8};
        System.out.println("Mediana (3er elemento) en [9,5,3,1,6,8]: " + 
                         QuickSelect.findKthSmallest(arr3, 3));
    }
}