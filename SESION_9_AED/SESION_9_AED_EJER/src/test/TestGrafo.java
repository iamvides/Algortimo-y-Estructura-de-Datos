package test;

import graph.GraphLink;

public class TestGrafo {

    public static void main(String[] args) {

        GraphLink grafo = new GraphLink();

        // Vértices y conexiones base
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("C", "D");

        System.out.println("Grafo original:");
        grafo.mostrarGrafo();

        // Prueba del EJERCICIO 1
        grafo.removeEdge("A", "B");
        System.out.println("\nDespués de eliminar arista A-B (EJERCICIO 1):");
        grafo.mostrarGrafo();

        // Prueba del EJERCICIO 2
        grafo.removeVertex("C");
        System.out.println("\nDespués de eliminar vértice C (EJERCICIO 2):");
        grafo.mostrarGrafo();

        // Prueba del EJERCICIO 3
        System.out.println("\nRecorrido DFS desde A (EJERCICIO 3):");
        grafo.dfs("A");
    }
}