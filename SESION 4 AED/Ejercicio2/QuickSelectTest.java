import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSelectTest {
    
    @Test
    public void testEjemplo1() {
        int[] arr = {4, 2, 7, 10, 4, 17};
        assertEquals(4, QuickSelect.findKthSmallest(arr, 3));
    }
    
    @Test
    public void testEjemplo2() {
        int[] arr = {4, 2, 7, 10, 4, 1, 6};
        assertEquals(6, QuickSelect.findKthSmallest(arr, 5));
    }
    
    @Test
    public void testPrimerElemento() {
        int[] arr = {9, 2, 7, 1, 7};
        assertEquals(1, QuickSelect.findKthSmallest(arr, 1));
    }
    
    @Test
    public void testUltimoElemento() {
        int[] arr = {5, 3, 9, 12, 6};
        assertEquals(12, QuickSelect.findKthSmallest(arr, 5));
    }
    
    @Test
    public void testArregloVacio() {
        int[] arr = {};
        assertThrows(IllegalArgumentException.class, () -> QuickSelect.findKthSmallest(arr, 1));
    }
}