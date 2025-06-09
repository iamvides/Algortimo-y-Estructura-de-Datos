package graph;

// Clase vértice para el grafo
public class Vertex {
    public String nombre;       // nombre del vértice
    public Edge arista;         // lista de aristas conectadas

    public Vertex(String nombre) {
        this.nombre = nombre;   // se guarda el nombre
        this.arista = null;     // aún no tiene aristas
    }
}
