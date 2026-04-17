import java.util.*;

public class dfs {
    public static void main(String[] args) {
        
        int V = 9;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).addAll(Arrays.asList(1, 2));
        graph.get(1).addAll(Arrays.asList(0, 3, 4));
        graph.get(2).addAll(Arrays.asList(0, 5));
        graph.get(3).addAll(Arrays.asList(1, 6));
        graph.get(4).addAll(Arrays.asList(1, 7));
        graph.get(5).addAll(Arrays.asList(2, 8));
        graph.get(6).add(3);
        graph.get(7).add(4);
        graph.get(8).add(5);

        ArrayList<Integer> traversal = new ArrayList<>();

        boolean[] visited = new boolean[V];
        dfs(graph, visited, traversal, 0);

        System.out.println(traversal);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> traversal, int node) {

        visited[node] = true;
        traversal.add(node);

        for (int x : graph.get(node)) {
            if (!visited[x]) {
                dfs(graph, visited, traversal, x);
            }
        }
    }

}
