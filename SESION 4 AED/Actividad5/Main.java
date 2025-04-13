public class Main {
    public static void main(String[] args) {
        int[] precios = {1, 5, 8, 9, 10, 17, 17, 20};
        int longitud = 8;
        
        // Solución naive (lenta para n > 30)
        System.out.println("Enfoque recursivo naive:");
        System.out.println("Max valor para longitud " + longitud + ": " + 
                         CorteVarillaNaive.maxValor(precios, longitud));
        
        // Solución DP (rápida incluso para n grandes)
        System.out.println("\nEnfoque programación dinámica:");
        System.out.println("Max valor para longitud " + longitud + ": " + 
                         CorteVarillaDP.maxValor(precios, longitud));
        
        // Comparación de tiempos (solo para demostración)
        System.out.println("\nComparación de tiempos (n=20):");
        compararTiempos(20);
    }
    
    private static void compararTiempos(int n) {
        int[] precios = new int[n];
        for (int i = 0; i < n; i++) precios[i] = i + 1;
        
        long inicio, fin;
        
        inicio = System.currentTimeMillis();
        CorteVarillaDP.maxValor(precios, n);
        fin = System.currentTimeMillis();
        System.out.println("DP: " + (fin - inicio) + " ms");
        
        inicio = System.currentTimeMillis();
        if (n <= 25) {  // No ejecutar para n grande (muy lento)
            CorteVarillaNaive.maxValor(precios, n);
        } else {
            System.out.println("Naive: No se ejecuta (n demasiado grande)");
        }
        fin = System.currentTimeMillis();
        if (n <= 25) System.out.println("Naive: " + (fin - inicio) + " ms");
    }
}