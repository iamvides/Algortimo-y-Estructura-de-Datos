import java.util.ArrayList;
import java.util.List;

public class SubconjuntoPotencias {

    /**
     * Verifica si existe un subconjunto que sume el objetivo con restricciones
     * @param nums Arreglo de enteros
     * @param target Suma objetivo
     * @return true si existe un subconjunto válido, false en caso contrario
     */
    public static boolean existeSubconjunto(int[] nums, int target) {
        List<Integer> obligatorios = new ArrayList<>();
        List<Integer> opcionales = new ArrayList<>();
        
        // Paso 1: Filtrar números según las reglas
        for (int i = 0; i < nums.length; i++) {
            if (esPotenciaDeDos(nums[i])) {
                obligatorios.add(nums[i]);
            } else if (nums[i] % 5 != 0 || (i < nums.length - 1 && nums[i + 1] % 2 == 0)) {
                opcionales.add(nums[i]);
            }
        }
        
        // Paso 2: Calcular suma de obligatorios
        int sumaObligatoria = obligatorios.stream().mapToInt(Integer::intValue).sum();
        
        // Paso 3: Verificar si los obligatorios solos superan el target
        if (sumaObligatoria > target) {
            return false;
        }
        
        // Paso 4: Buscar en opcionales la diferencia faltante
        return buscarCombinacion(opcionales, 0, target - sumaObligatoria);
    }
    
    /**
     * Método auxiliar para verificar si un número es potencia de 2
     */
    private static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    /**
     * Backtracking para encontrar combinación en opcionales
     */
    private static boolean buscarCombinacion(List<Integer> nums, int index, int remaining) {
        if (remaining == 0) {
            return true;
        }
        if (index >= nums.size() || remaining < 0) {
            return false;
        }
        // Incluir el número actual o no incluirlo
        return buscarCombinacion(nums, index + 1, remaining - nums.get(index)) || 
               buscarCombinacion(nums, index + 1, remaining);
    }
}