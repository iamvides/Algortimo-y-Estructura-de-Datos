package pypooeje1;

public class Verificador {
    public static boolean seSuperponen(Rectangulo r1, Rectangulo r2) {
        return r1.seSuperpone(r2);
    }

    public static boolean seJuntan(Rectangulo r1, Rectangulo r2) {
        return r1.seJuntan(r2);
    }

    public static double calcularAreaInterseccion(Rectangulo r1, Rectangulo r2) {
        return r1.areaInterseccion(r2);
    }
}