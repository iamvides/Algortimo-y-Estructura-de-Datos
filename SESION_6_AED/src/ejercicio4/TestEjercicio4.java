package ejercicio4;
import ejercicio4.Application;

public class TestEjercicio4 {
    public static void main(String[] args) {
        String[] pruebas = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}"
        };

        for (String s : pruebas) {
            System.out.println("Cadena: " + s + " -> ¿Balanceado?: " + Application.symbolBalancing(s));
        }
    }
}
