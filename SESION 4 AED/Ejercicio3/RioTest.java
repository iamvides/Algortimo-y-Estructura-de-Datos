import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RioTest {
    
    @Test
    public void testMatriz3x3() {
        int[][] tarifas = {
            {0, 5, 10},
            {0, 0, 3},
            {0, 0, 0}
        };
        
        int[][] esperado = {
            {0, 5, 8},
            {0, 0, 3},
            {0, 0, 0}
        };
        
        assertArrayEquals(esperado, CosteMinimoRio.calcularCostesMinimos(tarifas));
    }
    
    @Test
    public void testMatriz4x4() {
        int[][] tarifas = {
            {0, 10, 20, 30},
            {0, 0, 5, 15},
            {0, 0, 0, 5},
            {0, 0, 0, 0}
        };
        
        int[][] esperado = {
            {0, 10, 15, 20},
            {0, 0, 5, 10},
            {0, 0, 0, 5},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(esperado, CosteMinimoRio.calcularCostesMinimosOpt(tarifas));
    }
    
    @Test
    public void testMatriz5x5() {
        int[][] tarifas = {
            {0, 3, 10, 20, 25},
            {0, 0, 2, 8, 15},
            {0, 0, 0, 4, 10},
            {0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0}
        };
        
        int[][] resultado = CosteMinimoRio.calcularCostesMinimos(tarifas);
        assertEquals(9, resultado[0][4]); // Coste mínimo de 0→4
    }
}