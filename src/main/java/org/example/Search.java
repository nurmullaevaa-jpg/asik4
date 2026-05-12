package org.example;
import java.util.*;

abstract class Search<V> {
    protected Vertex<V> source;
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    public Search(Vertex<V> source) {
        this.source = source;
    }

    public boolean hasPathTo(Vertex<V> v) {
        return edgeTo.containsKey(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = v; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }
}