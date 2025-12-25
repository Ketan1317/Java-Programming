public class BST {

    private static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 0; // leaf node
        }
    }

    private Node root;

    public BST() {
    }

    // height utility
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ---------------- INSERT ----------------

    public void insert(int value) {
        root = insert(value, root);
    }

    public void insert(int[] arr) {
        for (int val : arr) {
            insert(val);
        }
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        }
        // duplicate values → ignored

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populateSorted(int[] arr) {
        populateSorted(arr, 0, arr.length);
    }

    private void populateSorted(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2;
        insert(arr[m]);
        populateSorted(arr, 0, m);
        populateSorted(arr, m + 1, e);
    }

    // ---------------- BALANCED CHECK ----------------

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                isBalanced(node.left) &&
                isBalanced(node.right);
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|---->" + node.value);
        } else {
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level + 1);
    }
}
