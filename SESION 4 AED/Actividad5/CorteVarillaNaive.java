/**
 * Solución naive recursiva (sin optimización)
 * Complejidad: O(2^n) - Exponencial
 */
public class CorteVarillaNaive {
    
    /**
     * Calcula el valor máximo obtenible cortando la varilla
     * @param precios Array donde precios[i] = valor de la pieza de longitud i+1
     * @param longitud Longitud total de la varilla
     * @return Valor máximo obtenible
     */
    public static int maxValor(int[] precios, int longitud) {
        if (longitud <= 0) return 0;
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < longitud; i++) {
            max = Math.max(max, 
                         precios[i] + maxValor(precios, longitud - i - 1));
        }
        return max;
    }
}