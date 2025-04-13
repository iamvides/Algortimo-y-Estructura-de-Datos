import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    
    private final int[] testArray = {1, 3, 5, 7, 9, 11, 13, 15};
    
    @Test
    public void testIterativeSearchFound() {
        assertEquals(2, BinarySearchIterative.binarySearch(testArray, 5));
        assertEquals(5, BinarySearchIterative.binarySearch(testArray, 11));
    }
    
    @Test
    public void testIterativeSearchNotFound() {
        assertEquals(-1, BinarySearchIterative.binarySearch(testArray, 8));
    }
    
    @Test
    public void testRecursiveSearchFound() {
        assertEquals(3, BinarySearchRecursive.binarySearch(testArray, 7));
        assertEquals(7, BinarySearchRecursive.binarySearch(testArray, 15));
    }
    
    @Test
    public void testRecursiveSearchNotFound() {
        assertEquals(-1, BinarySearchRecursive.binarySearch(testArray, 10));
    }
}