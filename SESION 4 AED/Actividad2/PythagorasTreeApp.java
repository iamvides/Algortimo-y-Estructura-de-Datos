import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class PythagorasTreeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ARBOL DE PITAGORAS");
        System.out.print("Ingrese el número de niveles (profundidad) del árbol: ");
        int niveles = scanner.nextInt();
        Color colorArbol = Color.GREEN;
        JFrame frame = new JFrame("Árbol de Pitágoras - " + niveles + " niveles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        PythagorasTree arbol = new PythagorasTree(niveles, colorArbol);
        frame.add(arbol);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        scanner.close();

    }
}