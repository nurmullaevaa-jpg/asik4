package org.example;
import java.util.*;

abstract class Search<V> {
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    protected Vertex<V> startVertex;

    public Search(Vertex<V> startVertex) {
        this.startVertex = startVertex;
    }

    // Метод pathTo возвращает Iterable<V>, как ожидает Main
    public Iterable<V> pathTo(V targetData) {
        LinkedList<V> path = new LinkedList<>();
        Vertex<V> target = null;

        for (Vertex<V> v : edgeTo.keySet()) {
            if (v.getData().equals(targetData)) {
                target = v;
                break;
            }
        }

        if (target == null && !startVertex.getData().equals(targetData)) return null;

        for (Vertex<V> x = target; x != null; x = edgeTo.get(x)) {
            path.addFirst(x.getData());
        }
        return path;
    }
}