package test;

import hash.*;

public class TestHash {

    public static void main(String[] args) {

        HashC tabla = new HashC(11); // tamaño fijo
        // Insertamos los valores que pide la guía
        tabla.insert(new Register(34, "Ana"));
        tabla.insert(new Register(3, "Luis"));
        tabla.insert(new Register(7, "Pablo"));
        tabla.insert(new Register(30, "Rosa"));
        tabla.insert(new Register(11, "Hugo"));
        tabla.insert(new Register(8, "Laura"));
        tabla.insert(new Register(7, "Pedro"));    // clave repetida
        tabla.insert(new Register(23, "Claudia"));
        tabla.insert(new Register(41, "Miguel"));
        tabla.insert(new Register(16, "Daniela"));
        tabla.insert(new Register(34, "Jorge")); // clave repetida

        // Mostrar tabla después de insertar
        tabla.printTable();

        System.out.println("\nEliminando clave 30...");
        tabla.delete(30);

        System.out.println("\nBuscando clave 23...");
        tabla.search(23);

        // Mostrar tabla después de eliminar y buscar
        tabla.printTable();
    }
}