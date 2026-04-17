import java.util.*;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> list;

    public Graph(int V) {
        this.V = V;
        list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u); // remove this line for directed graph
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + list.get(i));
        }
    }
}

