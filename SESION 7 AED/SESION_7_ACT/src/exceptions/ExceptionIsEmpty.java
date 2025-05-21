package exceptions;

// Excepción si el árbol está vacío
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String mensaje) {
        super(mensaje); // mensaje de error
    }
}