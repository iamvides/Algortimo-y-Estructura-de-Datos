package pypooeje5;

import java.util.ArrayList;

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

    public double calcularPromedioArea() {
        double suma = 0;
        for (double area : areas) {
            suma += area;
        }
        return (areas.size() > 0) ? suma / areas.size() : 0;
    }

    public Rectangulo obtenerMayorArea() {
        if (rectangulos.isEmpty()) return null;
        Rectangulo mayor = rectangulos.get(0);
        for (Rectangulo r : rectangulos) {
            if (r.calcularArea() > mayor.calcularArea()) {
                mayor = r;
            }
        }
        return mayor;
    }

    public Rectangulo obtenerMenorArea() {
        if (rectangulos.isEmpty()) return null;
        Rectangulo menor = rectangulos.get(0);
        for (Rectangulo r : rectangulos) {
            if (r.calcularArea() < menor.calcularArea()) {
                menor = r;
            }
        }
        return menor;
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