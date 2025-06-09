package graph;

import java.util.*;

// Clase del grafo no dirigido usando listas enlazadas
public class GraphLink {
    private List<Vertex> vertices; // lista de todos los vértices

    public GraphLink() {
        vertices = new LinkedList<>(); // lista vacía al inicio
    }

    // agrega un vértice si no existe
    public void insertVertex(String nombre) {
        if (!searchVertex(nombre)) {
            vertices.add(new Vertex(nombre));
        }
    }

    // busca si un vértice ya existe
    public boolean searchVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) return true;
        }
        return false;
    }

    // devuelve el vértice con ese nombre
    private Vertex getVertex(String nombre) {
        for (Vertex v : vertices) {
            if (v.nombre.equals(nombre)) return v;
        }
        return null;
    }

    // agrega una arista entre dos vértices (grafo no dirigido)
    public void insertEdge(String v1, String v2) {
        Vertex origen = getVertex(v1);
        Vertex destino = getVertex(v2);
        if (origen == null || destino == null) return;

        if (!searchEdge(v1, v2)) {
            origen.arista = new Edge(destino, origen.arista);
            destino.arista = new Edge(origen, destino.arista);
        }
    }

    // busca si hay arista entre dos vértices
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

    // muestra el grafo
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

        origen.arista = eliminarEnLista(origen.arista, v2);
        destino.arista = eliminarEnLista(destino.arista, v1);
    }

    // método para eliminar una arista de una lista
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

        for (Vertex v : vertices) {
            v.arista = eliminarEnLista(v.arista, nombre);
        }
        vertices.remove(eliminar);
    }

    // 🟩 EJERCICIO 3: recorrido en profundidad (DFS)
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

    // 🟩 EJERCICIO 5: contar número de vértices
    public int contarVertices() {
        return vertices.size(); // devolvemos el tamaño de la lista
    }

    // 🟩 EJERCICIO 6: contar número total de aristas
    public int contarAristas() {
        int total = 0;
        for (Vertex v : vertices) {
            Edge actual = v.arista;
            while (actual != null) {
                total++;
                actual = actual.siguiente;
            }
        }
        return total / 2; // porque es grafo no dirigido
    }

    // 🟩 EJERCICIO 7: obtener lista de adyacentes de un vértice
    public List<String> obtenerAdyacentes(String nombre) {
        List<String> adyacentes = new ArrayList<>();
        Vertex v = getVertex(nombre);
        if (v == null) return adyacentes;

        Edge actual = v.arista;
        while (actual != null) {
            adyacentes.add(actual.destino.nombre);
            actual = actual.siguiente;
        }
        return adyacentes;
    }

    // 🟩 EJERCICIO 8: verificar si un vértice es aislado
    public boolean esAislado(String nombre) {
        Vertex v = getVertex(nombre);
        if (v == null) return false;
        return v.arista == null; // si no tiene aristas, está solito
    }

    // 🟩 EJERCICIO 9: contar vértices aislados
    public int contarAislados() {
        int total = 0;
        for (Vertex v : vertices) {
            if (v.arista == null) total++;
        }
        return total;
    }
}
