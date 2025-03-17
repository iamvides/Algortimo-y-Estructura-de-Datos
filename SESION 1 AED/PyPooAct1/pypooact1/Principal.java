package pypooact1;

public class Principal {
    public static void main(String[] args) {
        Coordenada c1 = new Coordenada(1.5, 0.3);
        Coordenada c2 = new Coordenada(7.6, 2.2);
        Coordenada c3 = new Coordenada(4.0, 4.2);
        Coordenada c4 = new Coordenada(9.4, -2.5);

        Rectangulo rect1 = new Rectangulo(c1, c2);
        Rectangulo rect2 = new Rectangulo(c3, c4);

        System.out.println("Rectángulo A: " + rect1);
        System.out.println("Rectángulo B: " + rect2);

        if (Verificador.seSuperponen(rect1, rect2)) {
            System.out.println("Los rectángulos se sobreponen.");
        } else {
            System.out.println("Los rectángulos no se sobreponen.");
        }
    }
}