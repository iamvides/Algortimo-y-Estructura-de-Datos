package pypooeje2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContainerRect contenedor = new ContainerRect();

        System.out.print("Ingrese la cantidad de rectángulos: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese las coordenadas del rectángulo " + (i + 1) + ":");
            System.out.print("Ingrese una esquina: ");
            double x1 = sc.nextDouble(), y1 = sc.nextDouble();
            System.out.print("Ingrese la esquina opuesta: ");
            double x2 = sc.nextDouble(), y2 = sc.nextDouble();

            Rectangulo rect = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
            contenedor.addRectangulo(rect);
        }

        System.out.println("\nLista de Rectángulos almacenados:");
        System.out.println(contenedor);

        System.out.print("\n¿Desea eliminar un rectángulo? (Sí=1 / No=0): ");
        int eliminar = sc.nextInt();
        if (eliminar == 1) {
            System.out.print("Ingrese el número del rectángulo a eliminar: ");
            int index = sc.nextInt() - 1;
            contenedor.removeRectangulo(index);
            System.out.println("Lista actualizada de rectángulos:");
            System.out.println(contenedor);
        }

        System.out.print("\n¿Desea consultar un rectángulo? (Sí=1 / No=0): ");
        int consultar = sc.nextInt();
        if (consultar == 1) {
            System.out.print("Ingrese el número del rectángulo a consultar: ");
            int index = sc.nextInt() - 1;
            Rectangulo r = contenedor.getRectangulo(index);
            if (r != null) {
                System.out.println("Información del rectángulo seleccionado: " + r);
            } else {
                System.out.println("Número de rectángulo inválido.");
            }
        }

        sc.close();
    }
}
