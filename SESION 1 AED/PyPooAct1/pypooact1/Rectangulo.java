package pypooact1;

public class Rectangulo {
    private Coordenada esquina1, esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    public Coordenada getEsquina1() { return esquina1; }
    public Coordenada getEsquina2() { return esquina2; }

    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }
}