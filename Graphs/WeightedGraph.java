import java.util.*;

public class WeightedGraph {
    int V;
    ArrayList<ArrayList<Pair>> list;

    WeightedGraph(int V) {
        this.V = V;
        list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addWeightedEdge(int u, int v, int w) {
        list.get(u).add(new Pair(v, w));
        list.get(v).add(new Pair(u, w)); // for undirected only
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + list.get(i));
        }
    }
}


