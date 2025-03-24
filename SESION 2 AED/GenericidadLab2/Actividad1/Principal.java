package GenericidadLab2.Actividad1;
public class Principal {
    public static void main(String[] args) {
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(4);
        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");
        Chocolatina c3 = new Chocolatina("Snickers");
        Chocolatina c4 = new Chocolatina("Princesa");


        bolsaCho.add(c1);
        bolsaCho.add(c2);
        bolsaCho.add(c3);
        bolsaCho.add(c4);

        System.out.println("\nLista de Chocolatinas en la bolsa:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Prueba con Golosinas
        Bolsa<Golosina> bolsaGolosinas = new Bolsa<>(2);
        bolsaGolosinas.add(new Golosina("Caramelo", 10.5));
        bolsaGolosinas.add(new Golosina("Chicle", 5.0));

        System.out.println("\nLista de Golosinas en la bolsa:");
        for (Golosina golosina : bolsaGolosinas) {
            System.out.println(golosina);
        }
    }
}