import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el tipo de número:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            OperacionesMatBInteger op = new OperacionesMatBInteger();
            ejecutarMenu(sc, op, tipo);
        } else if (tipo == 2) {
            OperacionesMatBDouble op = new OperacionesMatBDouble();
            ejecutarMenu(sc, op, tipo);
        } else {
            System.out.println("Opción inválida.");
        }

        sc.close();
    }

    // Método genérico
    public static <T extends Number> void ejecutarOperacion(Operable<T> op, int opcion, T num1, T num2) {
        T resultado = switch (opcion) {
            case 1 -> op.suma(num1, num2);
            case 2 -> op.resta(num1, num2);
            case 3 -> op.producto(num1, num2);
            case 4 -> op.division(num1, num2);
            default -> null;
        };
        System.out.println("Resultado: " + resultado);
    }

    public static <T extends Number> void ejecutarMenu(Scanner sc, Operable<T> op, int tipo) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            if (opcion == 8) {
                continuar = false;
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("Ingrese el primer número: ");
            double num1 = sc.nextDouble();
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el segundo número: ");
                double num2 = sc.nextDouble();

                // Convertir a Integer
                if (tipo == 1) {
                    ejecutarOperacion(op, opcion, (T) Integer.valueOf((int) num1), (T) Integer.valueOf((int) num2));
                } else {
                    ejecutarOperacion(op, opcion, (T) Double.valueOf(num1), (T) Double.valueOf(num2));
                }
            } else if (opcion == 5) {
                System.out.println("Resultado: " + Math.pow(num1, 2));
            } else if (opcion == 6) {
                System.out.println("Resultado: " + Math.sqrt(num1));
            } else if (opcion == 7) {
                System.out.println("Resultado: " + Math.cbrt(num1));
            }
        }
    }
}
