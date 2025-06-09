package graph;

import java.util.*;

public class GraphLink {
    private List<Vertex> vertices;  // lista de todos los vértices

    public GraphLink() {
        vertices = new LinkedList<>(); // lista vacía al inicio
    }

    public void insertVertex(String nombre) {
        if (!searchVertex(nombre)) {
            vertices.add(new Vertex(nombre));
        }
    }

    public boolean searchVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) return true;
        }
        return false;
    }

    private Vertex getVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) return v;
        }
        return null;
    }

    public void insertEdge(String v1, String v2) {
        Vertex origen = getVertex(v1);
        Vertex destino = getVertex(v2);

        if (origen == null || destino == null) return;

        if (!searchEdge(v1, v2)) {
            origen.arista = new Edge(destino, origen.arista);
            destino.arista = new Edge(origen, destino.arista);
        }
    }

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

    // 🟩 EJERCICIO 1: eliminar arista
    public void removeEdge(String v1, String v2) {
        Vertex origen = getVertex(v1);
        Vertex destino = getVertex(v2);

        if (origen == null || destino == null) return;

        // eliminar arista v1 → v2
        origen.arista = eliminarEnLista(origen.arista, v2);
        // eliminar arista v2 → v1
        destino.arista = eliminarEnLista(destino.arista, v1);
    }

    private Edge eliminarEnLista(Edge actual, String destino) {
        if (actual == null) return null;
        if (actual.destino.nombre.equals(destino)) return actual.siguiente;

        Edge prev = actual;
        Edge curr = actual.siguiente;

        while (curr != null) {
            if (curr.destino.nombre.equals(destino)) {
                prev.siguiente = curr.siguiente;
                break;
            }
            prev = curr;
            curr = curr.siguiente;
        }
        return actual;
    }

    // 🟩 EJERCICIO 2: eliminar vértice
    public void removeVertex(String nombre) {
        Vertex eliminar = getVertex(nombre);
        if (eliminar == null) return;

        // eliminar referencias en los demás
        for (Vertex v : vertices) {
            v.arista = eliminarEnLista(v.arista, nombre);
        }

        // eliminar vértice de la lista
        vertices.remove(eliminar);
    }

    // 🟩 EJERCICIO 3: recorrer en profundidad (DFS)
    public void dfs(String inicio) {
        Set<String> visitado = new HashSet<>();
        Vertex v = getVertex(inicio);
        if (v == null) return;

        System.out.println("Recorrido DFS:");
        dfsRecursivo(v, visitado);
    }

    private void dfsRecursivo(Vertex v, Set<String> visitado) {
        if (visitado.contains(v.nombre)) return;

        System.out.println(v.nombre);
        visitado.add(v.nombre);

        Edge actual = v.arista;
        while (actual != null) {
            dfsRecursivo(actual.destino, visitado);
            actual = actual.siguiente;
        }
    }
}