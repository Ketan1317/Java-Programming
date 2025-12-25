import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // BinaryTree tree = new BinaryTree();
        // tree.populate(sc);
        // tree.display();

        AVL tree = new AVL();
        int[] arr = {1,2,3,4,5,6,7};
        tree.insert(arr);
        tree.prettyDisplay();

    }
}
