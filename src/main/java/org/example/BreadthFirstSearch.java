package org.example;
import java.util.*;

class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        bfs(source);
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);
        edgeTo.put(source, null);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> neighbor : v.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}