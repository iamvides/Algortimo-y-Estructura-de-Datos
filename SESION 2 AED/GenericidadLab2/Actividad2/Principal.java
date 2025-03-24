package GenericidadLab2.Actividad2;
public class Principal {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        // Pruebas de comparación
        System.out.println("Comparaciones de Arrays:");
        if (DemoMetodo.igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (DemoMetodo.igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (DemoMetodo.igualArrays(nums, nums3))
            System.out.println("nums es igual a nums3");
        if (DemoMetodo.igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");

        // Comparación correcta con Double[]
        Double dvals[] = {1.1, 2.2, 3.3, 4.4, 5.5};

        if (DemoMetodo.igualArrays(nums, dvals))
            System.out.println("nums es igual a dvals");

        System.out.println("\nFin del programa.");
    }
}
