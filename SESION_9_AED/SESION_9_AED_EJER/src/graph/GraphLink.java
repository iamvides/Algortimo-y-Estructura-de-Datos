package graph;

import java.util.*;

// Grafo no dirigido usando listas enlazadas
public class GraphLink {
    private List<Vertex> vertices;  // lista de todos los vértices

    public GraphLink() {
        vertices = new LinkedList<>(); // lista vacía al inicio
    }

    // Agrega vértice si no existe
    public void insertVertex(String nombre) {
        if (!searchVertex(nombre)) {
            vertices.add(new Vertex(nombre)); // agrega nuevo vértice
        }
    }

    // Verifica si un vértice existe
    public boolean searchVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) {
                return true; // ya existe
            }
        }
        return false;
    }

    // Busca y retorna el vértice si existe
    private Vertex getVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) return v;
        }
        return null;
    }

    // Inserta arista (no dirigida, así que en ambos lados)
    public void insertEdge(String v1, String v2) {
        Vertex origen = getVertex(v1);
        Vertex destino = getVertex(v2);

        if (origen == null || destino == null) return;

        if (!searchEdge(v1, v2)) {
            origen.arista = new Edge(destino, origen.arista); // inserta al inicio
            destino.arista = new Edge(origen, destino.arista); // también inverso
        }
    }

    // Busca si hay arista entre dos vértices
    public boolean searchEdge(String v1, String v2) {
        Vertex origen = getVertex(v1);
        if (origen == null) return false;

        Edge actual = origen.arista;
        while (actual != null) {
            if (actual.destino.nombre.equals(v2)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Muestra la lista de adyacencias de cada vértice
    public void mostrarGrafo() {
        for (Vertex v : vertices) {
            System.out.print(v.nombre + " → ");
            Edge actual = v.arista;
            while (actual != null) {
                System.out.print(actual.destino.nombre + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }
}
