public class Main22 {
    public static void main(String[] args) {
        // Ejemplo del enunciado
        int[][] tarifas = {
            {0, 5, 10, 20},
            {0, 0, 3, 8},
            {0, 0, 0, 4},
            {0, 0, 0, 0}
        };
        
        System.out.println("Matriz de tarifas directas:");
        imprimirMatriz(tarifas);
        
        int[][] costesMinimos = CosteMinimoRio.calcularCostesMinimosOpt(tarifas);
        
        System.out.println("\nMatriz de costes mínimos:");
        imprimirMatriz(costesMinimos);
        
        System.out.println("\nCoste mínimo de 0→3: " + costesMinimos[0][3]);
    }
    
    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
}