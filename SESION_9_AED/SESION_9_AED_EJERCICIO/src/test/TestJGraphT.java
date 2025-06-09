package test;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.GraphPath; 

public class TestJGraphT {

    public static void main(String[] args) {

        // Creamos grafo con pesos (vuelos)
        Graph<String, DefaultWeightedEdge> vuelos = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Agregamos ciudades
        vuelos.addVertex("Arequipa");
        vuelos.addVertex("Lima");
        vuelos.addVertex("Cusco");
        vuelos.addVertex("Tacna");
        vuelos.addVertex("Iquitos");

        // Agregamos vuelos con horas de duración
        vuelos.setEdgeWeight(vuelos.addEdge("Arequipa", "Lima"), 1.5);
        vuelos.setEdgeWeight(vuelos.addEdge("Lima", "Cusco"), 1.2);
        vuelos.setEdgeWeight(vuelos.addEdge("Lima", "Tacna"), 1.8);
        vuelos.setEdgeWeight(vuelos.addEdge("Cusco", "Iquitos"), 2.0);

        // Mostrar conexiones
        System.out.println("🛫 Conexiones de vuelo:");
        for (DefaultWeightedEdge e : vuelos.edgeSet()) {
            String origen = vuelos.getEdgeSource(e);
            String destino = vuelos.getEdgeTarget(e);
            double tiempo = vuelos.getEdgeWeight(e);
            System.out.println(origen + " → " + destino + " (" + tiempo + "h)");
        }

        // Mostrar ruta más corta Arequipa → Iquitos
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(vuelos);
        GraphPath<String, DefaultWeightedEdge> ruta = dijkstra.getPath("Arequipa", "Iquitos");

        System.out.println("\n🗺️ Ruta más corta de Arequipa a Iquitos:");
        if (ruta != null) {
            System.out.println("Camino: " + ruta.getVertexList());
            System.out.println("Duración total: " + ruta.getWeight() + " horas");
        } else {
            System.out.println("No hay ruta disponible.");
        }
    }
}