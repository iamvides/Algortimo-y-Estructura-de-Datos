package graph;

// Clase arista del grafo
public class Edge {
    public Vertex destino;      // a qué vértice va
    public Edge siguiente;      // siguiente arista

    public Edge(Vertex destino, Edge siguiente) {
        this.destino = destino;     // se guarda a quién conecta
        this.siguiente = siguiente; // se enlaza a la siguiente arista
    }
}
