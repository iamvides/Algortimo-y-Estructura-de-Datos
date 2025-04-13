public class CosteMinimoRio {

    /**
     * Calcula la matriz de costes mínimos entre todos los embarcaderos
     * @param tarifas Matriz triangular superior donde tarifas[i][j] = coste directo i→j
     * @return Matriz con los costes mínimos entre todos los pares
     */
    public static int[][] calcularCostesMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] dp = new int[n][n];
        
        // Inicialización: copiamos las tarifas directas
        for (int i = 0; i < n; i++) {
            System.arraycopy(tarifas[i], 0, dp[i], 0, n);
        }
        
        // Aplicamos programación dinámica
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (k > i && k < j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }
        
        return dp;
    }
    
    /**
     * Versión optimizada con complejidad O(n³)
     */
    public static int[][] calcularCostesMinimosOpt(int[][] tarifas) {
        int n = tarifas.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            System.arraycopy(tarifas[i], 0, dp[i], 0, n);
        }
        
        for (int len = 2; len <= n; len++) { // Longitud del tramo
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        return dp;
    }
}