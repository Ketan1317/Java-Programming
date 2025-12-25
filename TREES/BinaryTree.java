import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner sc) {
        System.out.println("Enter the Root node value : ");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you Want to Enter the Value left of " + node.value);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter Value left of " + node.value);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you Want to Enter the Value right of " + node.value);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter Value right of " + node.value);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    // Display
    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public Node levelOrderSuccessor(Node root, int key) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
            if (curr.value == key) {
                return q.peek();
            }
        }
        return null;
    }

}
