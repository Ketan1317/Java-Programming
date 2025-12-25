package LinkedList;

public class Main {

    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(78);
        list.insertFirst(456);
        list.insertFirst(5);
        list.insertFirst(56);
        list.insertFirst(7218);

        list.insertLast(69);

        list.insert(1000, 2);


        list.display();


    }
    
}
