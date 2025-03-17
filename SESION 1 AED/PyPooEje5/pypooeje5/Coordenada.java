package pypooeje5;

public class Coordenada {
    private double x, y;

    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }

    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(c.getX() - x, 2) + Math.pow(c.getY() - y, 2));
    }

    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}