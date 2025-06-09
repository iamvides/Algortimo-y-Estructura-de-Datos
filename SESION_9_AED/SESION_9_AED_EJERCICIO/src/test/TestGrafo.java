package test;

import graph.GraphLink;

public class TestGrafo {
    public static void main(String[] args) {
        GraphLink grafo = new GraphLink();

        // Agregamos algunos vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");

        // Conectamos los vértices
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");

        // Mostramos el grafo
        grafo.mostrarGrafo();
    }
}
