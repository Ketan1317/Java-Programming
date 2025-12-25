public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);

        tree.display();

        System.out.println("Query (2, 6): " + tree.query(2, 6));
        tree.update(3, 10);
        System.out.println("After update:");
        tree.display();
    }

    // ---------------- NODE ----------------
    private static class Node {
        int data;                 // sum of interval
        int startInterval;        // start index
        int endInterval;          // end index
        Node left;
        Node right;

        public Node(int start, int end) {
            this.startInterval = start;
            this.endInterval = end;
        }
    } 

    private Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {

        // Leaf node → single element
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;

        // Build left and right children
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // Internal node stores sum
        node.data = node.left.data + node.right.data;
        return node;
    }

    // ---------------- QUERY ----------------
    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {

        // Complete overlap
        if (qsi <= node.startInterval && node.endInterval <= qei) {
            return node.data;
        }

        // No overlap
        if (qei < node.startInterval || qsi > node.endInterval) {
            return 0;
        }

        // Partial overlap
        return query(node.left, qsi, qei) + query(node.right, qsi, qei);
    }

    // ---------------- UPDATE ----------------
    public void update(int index, int value) {
        update(root, index, value);
    }

    private int update(Node node, int idx, int value) {

        // Index outside this segment
        if (idx < node.startInterval || idx > node.endInterval) {
            return node.data;
        }

        // Leaf node update
        if (idx == node.startInterval && idx == node.endInterval) {
            node.data = value;
            return node.data;
        }

        // Recurse down
        int left = update(node.left, idx, value);
        int right = update(node.right, idx, value);

        // Recompute sum on way up
        node.data = left + right;
        return node.data;
    }

    // ---------------- DISPLAY ----------------
    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) return;

        display(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("|\t");
        }
        System.out.println("[" + node.startInterval + "," + node.endInterval + "] -> " + node.data);

        display(node.left, level + 1);
    }
}

