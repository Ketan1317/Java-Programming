
// TC -> O(4*alpha)
class DisjointSet {
    // Always attach the smaller set under the larger set

    // parent[i] = immediate parent of node i
    private int[] parent;

    // size[i] = size of tree rooted at i
    private int[] size;

    // Constructor: initialize n disjoint sets
    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the ultimate parent (leader) of a node
    // Uses path compression to flatten the tree
    // TC -> Amortized time constant
    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findParent(parent[node]); // path compression
        return parent[node];
    }

    // Union two sets using rank optimization
    public void unionBySize(int node1, int node2) {

        int root1 = findParent(node1);
        int root2 = findParent(node2);

        // If both nodes already belong to same set, do nothing
        if (root1 == root2) return;

        // Attach smaller rank tree under larger rank tree
        if (size[root1] < size[root2]) {
            parent[root1] = root2;
            size[root2] += size[root1];
        }
        else if (size[root2] < size[root1]) {
            parent[root2] = root1;
            size[root1] += size[root2];
        }
        else {
            // Same rank → choose one root and increase its rank
            parent[root2] = root1;
            size[root1] += size[root2];
        }
    }

    // Check if two nodes are in the same set
    public boolean areConnected(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }
     public void display() {
        System.out.println("Node : Parent : Size");
        for (int i = 1; i < parent.length; i++) {
            System.out.println("  " + i + "   :   " + parent[i] + "     :  " + size[i]);
        }
        System.out.println("-----------------------");
    }
}

public class DisjointBySize {
    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Check connectivity
        System.out.println(ds.areConnected(3, 7)); // false

        ds.unionBySize(3, 7);

        System.out.println(ds.areConnected(3, 7)); // true
        ds.display();
    }
}

