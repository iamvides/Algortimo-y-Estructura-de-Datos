public class Main {
    public static void main(String[] args) {
        // Caso del enunciado
        int[] nums1 = {4, 8, 10, 3, 5};
        System.out.println("Caso 1 (Esperado true): " + 
            SubconjuntoPotencias.existeSubconjunto(nums1, 27));
        
        // Caso alternativo
        int[] nums2 = {2, 16, 5, 1, 10};
        System.out.println("Caso 2 (Esperado true): " + 
            SubconjuntoPotencias.existeSubconjunto(nums2, 29));
        
        // Caso sin solución
        int[] nums3 = {1, 3, 5, 7};
        System.out.println("Caso 3 (Esperado false): " + 
            SubconjuntoPotencias.existeSubconjunto(nums3, 20));
    }
}