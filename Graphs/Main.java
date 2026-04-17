public class Main {
    public static void main(String[] args) {
        
        WeightedGraph g = new WeightedGraph(5);

        // g.addEdge(0, 1);
        // g.addEdge(0, 4);
        // g.addEdge(1, 2);
        // g.addEdge(1, 3);
        // g.addEdge(3, 4);

        g.addWeightedEdge(0, 1, 2);
        g.addWeightedEdge(0, 4, 1);
        g.addWeightedEdge(1, 2, 3);
        g.addWeightedEdge(1, 3, 4);
        g.addWeightedEdge(3, 4, 5);

        g.printGraph();
    }
}
