package actividad1;
// Clase para excepción personalizada
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String mensaje) {
        super(mensaje); // Llama al constructor de la clase Exception
    }
}