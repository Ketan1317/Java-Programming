public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public void insert(int val, int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (idx == 0) {
            insertFirst(val);
            return;
        }

        if (idx == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < idx; i++) {
            temp = temp.next;
        }

        Node node = new Node(val);
        
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
