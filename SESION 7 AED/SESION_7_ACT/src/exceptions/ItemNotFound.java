package exceptions;

// Excepción si el dato no se encuentra
public class ItemNotFound extends Exception {
    public ItemNotFound(String mensaje) {
        super(mensaje); // mensaje de error
    }
}