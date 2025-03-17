package pypooeje4;

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

    public double calcularDistancia() {
        return Coordenada.distancia(esquina1, esquina2);
    }

    public double calcularArea() {
        return Math.abs((xMax - xMin) * (yMax - yMin));
    }

    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }
}