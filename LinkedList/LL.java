package LinkedList;
public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }


        return node;
    }

    public int delete(int idx){
        if(idx == 0){
            return deleteFirst();
        }
        if(idx == size-1){
            return deleteLast();
        }

        Node prev = getNode(idx-1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        return val;

    }

    public Node getNode(int idx) {
        Node node = head;
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }

        return node;
    }

    public int deleteLast(){

        Node temp = head;

        for(int i = 1;i<size;i++){
            temp = temp.next;
        }

        int val = temp.value;
        temp.next = null;

        return val;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return val;
    }

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
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("END");

    }


    public void insertFirst(LinkedList head) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;

    }

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
