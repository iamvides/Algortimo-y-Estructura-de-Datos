package pypooeje1;

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