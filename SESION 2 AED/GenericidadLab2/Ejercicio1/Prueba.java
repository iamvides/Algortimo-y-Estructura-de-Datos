public class Prueba {
    public static void main(String[] args) {
        OperacionesMatBInteger operacionesMatBInteger = new OperacionesMatBInteger();
        System.out.println("Suma de enteros: " + operacionesMatBInteger.suma(1, 100));

        OperacionesMatBDouble operacionesMatBDouble = new OperacionesMatBDouble();
        System.out.println("Suma de dobles: " + operacionesMatBDouble.suma(1.5, 100.8));

        OperacionesMatB<Integer> operacionesMatB = new OperacionesMatB<>();
        System.out.println("Suma genérica: " + operacionesMatB.suma(2, 10));
    }
}
