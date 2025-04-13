import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CorteVarillaTest {
    private final int[] precios = {1, 5, 8, 9, 10, 17, 17, 20};
    
    @Test
    public void testNaive() {
        assertEquals(22, CorteVarillaNaive.maxValor(precios, 8));
        assertEquals(10, CorteVarillaNaive.maxValor(precios, 4));
    }
    
    @Test
    public void testDP() {
        assertEquals(22, CorteVarillaDP.maxValor(precios, 8));
        assertEquals(10, CorteVarillaDP.maxValor(precios, 4));
    }
    
    @Test
    public void testEdgeCases() {
        assertEquals(0, CorteVarillaDP.maxValor(precios, 0));
        assertEquals(1, CorteVarillaDP.maxValor(precios, 1));
    }
}