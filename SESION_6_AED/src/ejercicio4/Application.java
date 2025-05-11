package ejercicio4;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;
import ejercicio1.StackLink;

// Clase de aplicación para verificar balanceo de corchetes
public class Application {

    // Método estático que verifica si una cadena tiene corchetes bien anidados
    public static boolean symbolBalancing(String s) {
        Stack<Character> pila = new StackLink<>(); // Usamos StackLink como pila

        for (char c : s.toCharArray()) {
            // Si es un símbolo de apertura, lo apilamos
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }
            // Si es un símbolo de cierre, verificamos si corresponde
            else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false; // Si no hay nada que cerrar

                try {
                    char tope = pila.pop(); // Tomamos el símbolo en el tope
                    if (!corresponden(tope, c)) {
                        return false; // No hace pareja correctamente
                    }
                } catch (ExceptionIsEmpty e) {
                    return false; // Nunca debería ocurrir por el if anterior
                }
            }
        }

        return pila.isEmpty(); // Si al final está vacía, todo está balanceado
    }

    // Verifica si un símbolo de apertura y uno de cierre hacen pareja correcta
    private static boolean corresponden(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
}