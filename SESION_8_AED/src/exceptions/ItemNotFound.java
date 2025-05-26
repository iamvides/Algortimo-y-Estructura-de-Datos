package exceptions;

// Excepción si el elemento no se encuentra
public class ItemNotFound extends Exception {
    public ItemNotFound(String mensaje) {
        super(mensaje);
    }
}
