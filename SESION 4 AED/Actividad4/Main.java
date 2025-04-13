public class Main {
    public static void main(String[] args) {
        // Ejemplo 1: Moda única
        int[] arr1 = {3, 7, 3, 1, 3, 7, 1, 3};
        System.out.println("Moda de [3,7,3,1,3,7,1,3]: " + Moda.encontrarModa(arr1));

        // Ejemplo 2: Empate (devuelve la primera encontrada)
        int[] arr2 = {1, 2, 2, 3, 3};
        System.out.println("Moda de [1,2,2,3,3]: " + Moda.encontrarModa(arr2));

        // Ejemplo 3: Todos únicos
        int[] arr3 = {10, 20, 30};
        System.out.println("Moda de [10,20,30]: " + Moda.encontrarModa(arr3));
    }
}