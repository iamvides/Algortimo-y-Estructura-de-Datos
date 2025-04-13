import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubconjuntoTest {
    
    @Test
    public void testCaso1() {
        int[] nums = {4, 8, 10, 3, 5};
        assertTrue(SubconjuntoPotencias.existeSubconjunto(nums, 27));
    }
    
    @Test
    public void testCaso2() {
        int[] nums = {4, 8, 10, 3, 6};
        assertFalse(SubconjuntoPotencias.existeSubconjunto(nums, 27));
    }
    
    @Test
    public void testCaso3() {
        int[] nums = {2, 16, 5, 7, 10};
        assertTrue(SubconjuntoPotencias.existeSubconjunto(nums, 33));
    }
    
    @Test
    public void testCaso4() {
        int[] nums = {2, 16, 5, 3, 10};
        assertFalse(SubconjuntoPotencias.existeSubconjunto(nums, 33));
    }
    
    @Test
    public void testCaso5() {
        int[] nums = {2, 5, 1, 6};
        assertTrue(SubconjuntoPotencias.existeSubconjunto(nums, 13));
    }
}