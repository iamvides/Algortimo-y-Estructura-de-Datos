package exceptions;

// Excepción si el elemento ya existe
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String mensaje) {
        super(mensaje);
    }
}
