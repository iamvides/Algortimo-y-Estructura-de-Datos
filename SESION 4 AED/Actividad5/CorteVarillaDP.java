/**
 * Solución optimizada con programación dinámica
 * Complejidad: O(n^2) - Polinómica
 */
public class CorteVarillaDP {

    /**
     * Calcula el valor máximo usando DP con memorización
     * @param precios Array de precios por longitud
     * @param n Longitud total
     * @return Valor máximo
     */
    public static int maxValor(int[] precios, int n) {
        int[] dp = new int[n + 1];  // dp[i] = max valor para longitud i
        dp[0] = 0;  // Caso base
        
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, precios[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}