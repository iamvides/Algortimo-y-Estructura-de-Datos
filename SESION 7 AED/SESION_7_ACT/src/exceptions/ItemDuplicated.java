package exceptions;

// Excepción si el dato ya existe
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String mensaje) {
        super(mensaje); // mensaje de error
    }
}