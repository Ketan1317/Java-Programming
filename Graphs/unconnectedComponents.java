
import java.util.*;

public class unconnectedComponents {
    public static void main(String[] args) {
        int V = 10;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).addAll(Arrays.asList(1, 2));
        graph.get(1).addAll(Arrays.asList(0, 3, 4));
        graph.get(2).add(0);
        graph.get(3).add(1);
        graph.get(4).add(1);

        graph.get(5).add(6);
        graph.get(6).addAll(Arrays.asList(5, 7));
        graph.get(7).add(6);

        graph.get(8).add(9);
        graph.get(9).add(8);

        int components = traversal(V, graph);
        System.out.println(components);

    }

    public static int traversal(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        int components = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                bfs(i, visited, graph);
            }
        }
        return components;
    }

    public static void bfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();

            for (int x : graph.get(node)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }

        }

    }
}
