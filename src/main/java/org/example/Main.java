package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем граф
        WeightedGraph<String> graph = new WeightedGraph<>();

        // 2. Создаем вершины
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        // 3. Добавляем связи (для BFS веса не важны, но они должны быть в структуре)
        a.addAdjacentVertex(b, 1.0);
        b.addAdjacentVertex(c, 1.0);
        a.addAdjacentVertex(c, 5.0); // Прямой путь длиннее по весу, но короче по шагам
        c.addAdjacentVertex(d, 1.0);

        // Регистрируем все вершины в графе
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        // --- ИСПОЛЬЗОВАНИЕ BFS ---
        System.out.println("--- Результаты BFS ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, a);

        if (bfs.hasPathTo(d)) {
            System.out.print("Путь от A до D (BFS): ");
            for (Vertex<String> v : bfs.pathTo(d)) {
                System.out.print(v.getData() + " ");
            }
            // Выведет: A C D (так как это меньше всего "прыжков" по ребрам)
            System.out.println();
        }

        // --- ИСПОЛЬЗОВАНИЕ DIJKSTRA ---
        System.out.println("\n--- Результаты Dijkstra ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, a);

        if (dijkstra.hasPathTo(d)) {
            System.out.print("Путь от A до D (Dijkstra): ");
            for (Vertex<String> v : dijkstra.pathTo(d)) {
                System.out.print(v.getData() + " ");
            }
            // Выведет: A B C D (вес 1+1+1=3, что меньше прямого пути A-C весом 5)
            System.out.println("\nОбщая дистанция: " + dijkstra.getDistanceTo(d));
        }
    }
}