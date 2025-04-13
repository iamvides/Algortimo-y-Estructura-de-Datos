import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModaTest {

    @Test
    public void testModaBasica() {
        int[] arr = {1, 2, 2, 3, 4};
        assertEquals(2, Moda.encontrarModa(arr));
    }

    @Test
    public void testModaTodosIguales() {
        int[] arr = {5, 5, 5};
        assertEquals(5, Moda.encontrarModa(arr));
    }

    @Test
    public void testModaSinRepeticiones() {
        int[] arr = {1, 2, 3};
        // En caso de empate, devuelve el primero encontrado
        assertTrue(Arrays.asList(1, 2, 3).contains(Moda.encontrarModa(arr)));
    }

    @Test
    public void testModaConNegativos() {
        int[] arr = {-1, -1, -2, 0, 1};
        assertEquals(-1, Moda.encontrarModa(arr));
    }

    @Test
    public void testArregloVacio() {
        int[] arr = {};
        assertThrows(IllegalArgumentException.class, () -> Moda.encontrarModa(arr));
    }
}