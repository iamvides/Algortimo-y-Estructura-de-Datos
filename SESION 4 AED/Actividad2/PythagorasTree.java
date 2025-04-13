import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JPanel {
    private int profundidad;
    private Color colorBase;

    public PythagorasTree(int profundidad) {
        this(profundidad, Color.GREEN);
    }

    public PythagorasTree(int profundidad, Color colorBase) {
        this.profundidad = profundidad;
        this.colorBase = colorBase;
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                           RenderingHints.VALUE_ANTIALIAS_ON);
        
        trazaArbol(g2d, 400, 600, 120, -90, profundidad, colorBase);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, 
                          double angulo, int nivel, Color color) {
        if (nivel <= 0 || lado < 2) return;

        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.setColor(color);
        g.setStroke(new BasicStroke(nivel * 0.7f));
        g.drawLine(x, y, x2, y2);

        Color nuevoColor = new Color(
            Math.min(255, color.getRed() + 30),
            Math.max(0, color.getGreen() - 20),
            color.getBlue());

        int nuevoLado = (int) (lado * 0.7);

        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1, nuevoColor);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1, nuevoColor);
    }
}