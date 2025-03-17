package pypooact1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una esquina del 1er rectángulo: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        System.out.print("Ingrese una esquina del 2do rectángulo: ");
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x4 = sc.nextDouble(), y4 = sc.nextDouble();

        Rectangulo rect1 = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        Rectangulo rect2 = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        System.out.println("Rectángulo A = " + rect1);
        System.out.println("Rectángulo B = " + rect2);

        if (Verificador.seSuperponen(rect1, rect2)) {
            System.out.println("Rectángulos A y B se sobreponen.");
            System.out.println("Área de sobreposición = " + Verificador.calcularAreaInterseccion(rect1, rect2));
        } else if (Verificador.seJuntan(rect1, rect2)) {
            System.out.println("Rectángulos A y B se juntan.");
        } else {
            System.out.println("Rectángulos A y B son disjuntos.");
        }
        
        sc.close();
    }
}