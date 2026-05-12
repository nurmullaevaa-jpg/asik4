package org.example;
import java.util.*;

class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo = new HashMap<>();
    private final PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, V startData) {
        super(graph.getVertex(startData));
        pq = new PriorityQueue<>(Comparator.comparing(v -> distTo.getOrDefault(v, Double.POSITIVE_INFINITY)));

        for (Vertex<V> v : graph.getAllVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        Vertex<V> start = graph.getVertex(startData);
        distTo.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (var entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w, double weight) {
        if (distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.remove(w);
            pq.add(w);
        }
    }
}