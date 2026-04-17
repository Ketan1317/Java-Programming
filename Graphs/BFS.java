import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

        System.out.println(bfs(V,graph));
    }

    public static ArrayList<Integer> bfs(int V,ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        ArrayList<Integer> traversal = new ArrayList<>();
        
        boolean[] visited = new boolean[V];
        visited[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            traversal.add(node);
            for(Integer x : graph.get(node)){
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return traversal;
    }
}
