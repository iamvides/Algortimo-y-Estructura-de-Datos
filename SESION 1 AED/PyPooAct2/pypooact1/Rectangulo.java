package pypooact1;

public class Rectangulo {
    private Coordenada esquina1, esquina2;
    private double xMin, xMax, yMin, yMax;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
        ordenarCoordenadas();
    }

    private void ordenarCoordenadas() {
        xMin = Math.min(esquina1.getX(), esquina2.getX());
        xMax = Math.max(esquina1.getX(), esquina2.getX());
        yMin = Math.min(esquina1.getY(), esquina2.getY());
        yMax = Math.max(esquina1.getY(), esquina2.getY());
    }

    public Coordenada getEsquina1() { return esquina1; }
    public Coordenada getEsquina2() { return esquina2; }

    public boolean seSuperpone(Rectangulo otro) {
        return !(xMax <= otro.xMin || xMin >= otro.xMax || yMax <= otro.yMin || yMin >= otro.yMax);
    }

    public boolean seJuntan(Rectangulo otro) {
        return (xMax == otro.xMin || xMin == otro.xMax || yMax == otro.yMin || yMin == otro.yMax);
    }

    public double areaInterseccion(Rectangulo otro) {
        if (!seSuperpone(otro)) return 0;
        double ancho = Math.min(xMax, otro.xMax) - Math.max(xMin, otro.xMin);
        double alto = Math.min(yMax, otro.yMax) - Math.max(yMin, otro.yMin);
        return ancho * alto;
    }

    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }
}