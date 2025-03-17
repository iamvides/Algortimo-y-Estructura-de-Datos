package pypooeje3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContainerRect {
    private ArrayList<Rectangulo> rectangulos;
    private ArrayList<Double> distancias;
    private ArrayList<Double> areas;

    public ContainerRect() {
        rectangulos = new ArrayList<>();
        distancias = new ArrayList<>();
        areas = new ArrayList<>();
    }

    public void addRectangulo(Rectangulo r) {
        rectangulos.add(r);
        distancias.add(r.calcularDistancia());
        areas.add(r.calcularArea());
    }

    public void removeRectangulo(int index) {
        if (index >= 0 && index < rectangulos.size()) {
            rectangulos.remove(index);
            distancias.remove(index);
            areas.remove(index);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public Rectangulo getRectangulo(int index) {
        if (index >= 0 && index < rectangulos.size()) {
            return rectangulos.get(index);
        }
        return null;
    }

    public void ordenarPorArea() {
        Collections.sort(rectangulos, Comparator.comparing(Rectangulo::calcularArea));
    }

    public int buscarPorArea(double area) {
        for (int i = 0; i < areas.size(); i++) {
            if (Math.abs(areas.get(i) - area) < 0.01) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo\tCoordenadas\t\tDistancia\tÁrea\n");
        for (int i = 0; i < rectangulos.size(); i++) {
            sb.append((i + 1) + "\t" + rectangulos.get(i) + "\t" +
                      String.format("%.3f", distancias.get(i)) + "\t" +
                      String.format("%.3f", areas.get(i)) + "\n");
        }
        return sb.toString();
    }
}