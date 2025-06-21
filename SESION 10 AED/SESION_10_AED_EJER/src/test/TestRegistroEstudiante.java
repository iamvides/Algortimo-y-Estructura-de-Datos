package test;

import btree.BTree;
import modelo.RegistroEstudiante;

public class TestRegistroEstudiante {
    public static void main(String[] args) {
        // Crear árbol B de orden 4
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        // Insertar estudiantes
        arbol.insert(new RegistroEstudiante(103, "Ana"));
        arbol.insert(new RegistroEstudiante(110, "Luis"));
        arbol.insert(new RegistroEstudiante(101, "Carlos"));
        arbol.insert(new RegistroEstudiante(120, "Lucía"));
        arbol.insert(new RegistroEstudiante(115, "David"));
        arbol.insert(new RegistroEstudiante(125, "Jorge"));
        arbol.insert(new RegistroEstudiante(140, "Camila"));
        arbol.insert(new RegistroEstudiante(108, "Rosa"));
        arbol.insert(new RegistroEstudiante(132, "Ernesto"));
        arbol.insert(new RegistroEstudiante(128, "Denis"));
        arbol.insert(new RegistroEstudiante(145, "Enrique"));
        arbol.insert(new RegistroEstudiante(122, "Karina"));
        arbol.insert(new RegistroEstudiante(108, "Juan")); // Repetido (clave duplicada)

        // Buscar estudiante con código 115
        System.out.println("\nBuscar 115: " + arbol.buscarNombre(115)); // David

        // Buscar estudiante con código 132
        System.out.println("Buscar 132: " + arbol.buscarNombre(132)); // Ernesto

        // Buscar estudiante con código 999
        System.out.println("Buscar 999: " + arbol.buscarNombre(999)); // No encontrado

        // Eliminar estudiante con código 101
        System.out.println("\nEliminando 101...");
        arbol.remove(new RegistroEstudiante(101, "Carlos"));

        // Insertar nuevo estudiante 106
        System.out.println("Insertando 106 - Sara...");
        arbol.insert(new RegistroEstudiante(106, "Sara"));

        // Buscar 106
        System.out.println("Buscar 106: " + arbol.buscarNombre(106)); // Sara

        // Mostrar árbol como tabla
        System.out.println("\nTabla de nodos:");
        arbol.printTable();
    }
}
