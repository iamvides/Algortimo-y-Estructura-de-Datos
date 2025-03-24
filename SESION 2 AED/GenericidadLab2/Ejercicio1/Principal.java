import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacionesMatDouble operaciones = new OperacionesMatDouble(); 

        int opcion;
        do {
            System.out.println("Menú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("Ingrese el primer número: ");
                double num1 = scanner.nextDouble();
                double num2 = 0;
                if (opcion <= 5) {
                    System.out.print("Ingrese el segundo número: ");
                    num2 = scanner.nextDouble();
                }

                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + operaciones.suma(num1, num2));
                    case 2 -> System.out.println("Resultado: " + operaciones.resta(num1, num2));
                    case 3 -> System.out.println("Resultado: " + operaciones.producto(num1, num2));
                    case 4 -> System.out.println("Resultado: " + operaciones.division(num1, num2));
                    case 5 -> System.out.println("Resultado: " + operaciones.potencia(num1, (int) num2));
                    case 6 -> System.out.println("Resultado: " + operaciones.raizCuadrada(num1));
                    case 7 -> System.out.println("Resultado: " + operaciones.raizCubica(num1));
                }
            }
        } while (opcion != 8);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}