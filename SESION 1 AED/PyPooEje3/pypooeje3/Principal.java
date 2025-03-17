package pypooeje3;

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

        System.out.println("\nOrdenando rectángulos por área...");
        contenedor.ordenarPorArea();
        System.out.println(contenedor);

        System.out.print("\nIngrese un área a buscar: ");
        double areaBuscada = sc.nextDouble();
        int index = contenedor.buscarPorArea(areaBuscada);
        if (index != -1) {
            System.out.println("Rectángulo encontrado: " + contenedor.getRectangulo(index));
        } else {
            System.out.println("No se encontró un rectángulo con esa área.");
        }

        sc.close();
    }
}