public class CLL {
    private Node head;
    private Node tail;
    private int size;

    // Constructor initializes an empty circular linked list
    public CLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 🧹 Deletes the first node that matches the given value
    public void delete(int val) {
        Node node = head;

        // If the list is empty, nothing to delete
        if (node == null) {
            return;
        }

        // Case 1: Deleting the head node
        if (node.value == val) {
            // If there is only one node
            if (head == tail) {
                head = null;
                tail = null;
                size--;
                return;
            }

            // Otherwise, move head forward and fix tail's next
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        // Case 2: Deleting any other node
        do {
            Node n = node.next;
            if (n.value == val) {
                node.next = n.next;

                // If the deleted node was tail, update tail
                if (n == tail) {
                    tail = node;
                }

                size--;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    // ➕ Inserts a new node at the end of the circular linked list
    public void insertLast(int val) {
        Node node = new Node(val);

        // If list is empty, new node becomes head and tail
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head; // Circular link
            size++;
            return;
        }

        // Otherwise, link the new node at the end
        tail.next = node;
        node.next = head; // Maintain circular connection
        tail = node; // Move tail to new node
        size++;
    }

    // 👁 Displays all nodes in circular fashion
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to HEAD)");
    }

    // 🧩 Inner class representing each node in the CLL
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
