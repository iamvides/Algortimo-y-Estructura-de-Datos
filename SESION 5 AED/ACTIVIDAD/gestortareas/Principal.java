public class Principal {
    public static void main(String[] args) {
        ServicioTareas<?> gestor = new ServicioTareas<>();
        System.out.println("Bienvenido al Gestor de Tareas");
        gestor.mostrarMenu();
    }
}