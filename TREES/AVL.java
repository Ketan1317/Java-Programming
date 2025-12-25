import org.w3c.dom.Node;

public class AVL {

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

    public AVL() {
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
        return rotate(node);
    }

    public Node rotate(Node node) {

        int balance = height(node.left) - height(node.right);

        // Left Heavy
        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                // Left-Left
                return rightRotate(node);
            } else {
                // Left-Right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                // Right-Right
                return leftRotate(node);
            } else {
                // Right-Left
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
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
        populateSorted(arr, s, m);
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

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null)
            return null;
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Value found
            // One or No Child case
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null && node.right != null) {
                node = node.right;
            } else if (node.left != null && node.right == null) {
                node = node.left;
            } else {
                // Both childs
                Node successor = getMin(node.right);
                node.value = successor.value;
                node.right = delete(node.right, successor.value);
            }
        }

        // If tree had only one node
        if (node == null)
            return null;

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Rebalance
        return rotate(node);

    }

    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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
