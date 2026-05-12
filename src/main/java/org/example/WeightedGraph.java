package org.example;
import java.util.*;
class WeightedGraph<V> {
    private final Map<V, Vertex<V>> vertices = new HashMap<>();
    private final boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addEdge(V source, V dest, double weight) {
        if (!vertices.containsKey(source)) vertices.put(source, new Vertex<>(source));
        if (!vertices.containsKey(dest)) vertices.put(dest, new Vertex<>(dest));

        vertices.get(source).addAdjacentVertex(vertices.get(dest), weight);
        if (undirected) {
            vertices.get(dest).addAdjacentVertex(vertices.get(source), weight);
        }
    }

    public Vertex<V> getVertex(V data) { return vertices.get(data); }
    public Collection<Vertex<V>> getAllVertices() { return vertices.values(); }
}