package test;

import hash.*;

public class TestHashOpen {
    public static void main(String[] args) {
        HashO tabla = new HashO(5); // Tamaño reducido para provocar colisiones

        // Insertar registros con colisiones intencionales
        tabla.insert(new Register(10, "Ana"));    // 10 % 5 = 0
        tabla.insert(new Register(15, "Luis"));   // 15 % 5 = 0 (colisión con 10)
        tabla.insert(new Register(7, "Pablo"));    // 7 % 5 = 2
        tabla.insert(new Register(12, "Rosa"));    // 12 % 5 = 2 (colisión con 7)
        tabla.insert(new Register(3, "Hugo"));     // 3 % 5 = 3
        tabla.insert(new Register(8, "Laura"));    // 8 % 5 = 3 (colisión con 3)
        tabla.insert(new Register(8, "Alex"));    // 8 % 5 = 3 (colisión con 3)

        // Mostrar tabla hash abierta con sus listas enlazadas
        tabla.printTable();
    }
}
