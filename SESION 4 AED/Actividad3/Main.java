public class Main {
    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14, 16};
        int target = 10;
        
        // Búsqueda iterativa
        int resultIterative = BinarySearchIterative.binarySearch(sortedArray, target);
        System.out.println("Iterative: Elemento " + target + 
                          (resultIterative != -1 ? " encontrado en índice " + resultIterative : " no encontrado"));
        
        // Búsqueda recursiva
        int resultRecursive = BinarySearchRecursive.binarySearch(sortedArray, target);
        System.out.println("Recursive: Elemento " + target + 
                          (resultRecursive != -1 ? " encontrado en índice " + resultRecursive : " no encontrado"));
    }
}