package ds;

import java.util.*;

public class Graph<T> {
    class Vertex<T> {
        T value;
        Vertex(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return value.equals(vertex.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
    Map<Vertex, Set<Vertex>> adjacentList = new HashMap<>();

    public void addVertex(T t) {
        adjacentList.putIfAbsent(new Vertex(t), new HashSet<>());
    }

    public void addEdge(T t1, T t2) {
        addVertex(t1);
        addVertex(t2);
        adjacentList.get(new Vertex(t1)).add(new Vertex(t2));
        adjacentList.get(new Vertex(t2)).add(new Vertex(t1));
    }

    public void removeEdge(T t1, T t2) {
        var vertex1 = new Vertex(t1);
        var vertex2 = new Vertex(t2);

        if(!adjacentList.containsKey(vertex1) ||
                !adjacentList.containsKey(vertex2))
            throw new RuntimeException("Invalid vertices");
        adjacentList.get(vertex1).remove(vertex2);
        adjacentList.get(vertex2).remove(vertex1);
    }

    public void removeVertex(T t) {
        var vertex = new Vertex(t);
        if(!adjacentList.containsKey(vertex))
            throw new RuntimeException("Invalid vertex");
        adjacentList.remove(vertex);
        for(Map.Entry<Vertex, Set<Vertex>> entry : adjacentList.entrySet()) {
            entry.getValue().remove(vertex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Vertex, Set<Vertex>> entry : adjacentList.entrySet()) {
            sb.append(entry.getKey().value);
            sb.append("-->");
            for(Vertex<T> vertex : entry.getValue()) {
                sb.append(vertex.value + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var graph = new Graph<Integer>();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);

        System.out.println(graph);

        graph.removeEdge(6, 5);
        graph.removeVertex(4);
        System.out.println(graph);

        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(6, 5);
        System.out.println(graph);
    }
}