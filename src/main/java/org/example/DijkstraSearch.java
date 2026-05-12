package org.example;
import java.util.*;

class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo = new HashMap<>();
    private PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(distTo::get));

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        edgeTo.put(source, null);
        pq.add(source);

        while (!pq.isEmpty()) {
            relax(pq.poll());
        }
    }

    private void relax(Vertex<V> v) {
        for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
            Vertex<V> neighbor = entry.getKey();
            double weight = entry.getValue();
            if (distTo.get(neighbor) > distTo.get(v) + weight) {
                distTo.put(neighbor, distTo.get(v) + weight);
                edgeTo.put(neighbor, v);
                pq.remove(neighbor);
                pq.add(neighbor);
            }
        }
    }

    public double getDistanceTo(Vertex<V> v) {
        return distTo.get(v);
    }
}