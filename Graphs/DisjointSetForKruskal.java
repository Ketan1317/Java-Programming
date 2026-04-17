
class DisjointSet {

    // parent[i] = immediate parent of node i
    private int[] parent;

    // rank[i] = approximate height of tree rooted at i
    private int[] rank;

    // Constructor: initialize n disjoint sets
    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the ultimate parent (leader) of a node
    // Uses path compression to flatten the tree
    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findParent(parent[node]); // path compression
        return parent[node];
    }

    // Union two sets using rank optimization
    public void unionByRank(int node1, int node2) {

        int root1 = findParent(node1);
        int root2 = findParent(node2);

        // If both nodes already belong to same set, do nothing
        if (root1 == root2) return;

        // Attach smaller rank tree under larger rank tree
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        }
        else if (rank[root2] < rank[root1]) {
            parent[root2] = root1;
        }
        else {
            // Same rank → choose one root and increase its rank
            parent[root2] = root1;
            rank[root1]++;
        }
    }

    // Check if two nodes are in the same set
    public boolean areConnected(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }
     public void display() {
        System.out.println("Node : Parent : Rank");
        for (int i = 1; i < parent.length; i++) {
            System.out.println("  " + i + "   :   " + parent[i] + "     :  " + rank[i]);
        }
        System.out.println("-----------------------");
    }
}

public class DisjointSetForKruskal {
    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check connectivity
        System.out.println(ds.areConnected(3, 7)); // false

        ds.unionByRank(3, 7);

        System.out.println(ds.areConnected(3, 7)); // true
        ds.display();
    }
}
