package org.example;
import java.util.*;
import java.util.*;

public class WeightedGraph<V> {
    protected Map<V, Vertex<V>> vertices = new HashMap<>();
    protected boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addEdge(V source, V dest, double weight) {
        vertices.putIfAbsent(source, new Vertex<>(source));
        vertices.putIfAbsent(dest, new Vertex<>(dest));

        vertices.get(source).addAdjacentVertex(vertices.get(dest), weight);
        if (undirected) {
            vertices.get(dest).addAdjacentVertex(vertices.get(source), weight);
        }
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
    public Vertex<V> getVertex(V data) { return vertices.get(data); }
}