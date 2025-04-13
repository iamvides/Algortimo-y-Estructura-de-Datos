import java.util.Scanner;

public class Hanoi {
    private static int contadorMovimientos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("JUEGO DE LAS TORRES DE HANOI");
        System.out.print("Ingrese el número de discos: ");
        int discos = scanner.nextInt();
        
        if (discos < 1) {
            System.out.println("Debe ingresar un número positivo de discos.");
            return;
        }
        
        System.out.println("\nSecuencia de movimientos para " + discos + " discos:");
        torresHanoi(discos, 'A', 'B', 'C'); 
        
        System.out.println("\nTotal de movimientos: " + contadorMovimientos);
        
        scanner.close();
    }

    public static void torresHanoi(int discos, char origen, char auxiliar, char destino) {
        if (discos == 1) {
            System.out.println("Mover disco 1 de la torre " + origen + " a la torre " + destino);
            contadorMovimientos++;
            return;
        }
        
        torresHanoi(discos - 1, origen, destino, auxiliar);
        
        System.out.println("Mover disco " + discos + " de la torre " + origen + " a la torre " + destino);
        contadorMovimientos++;
        
        torresHanoi(discos - 1, auxiliar, origen, destino);
    }
}