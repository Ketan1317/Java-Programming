public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(4);
        heap.insert(35343);
        heap.insert(3344);
        heap.insert(354);
        heap.insert(304);
        heap.insert(56);
        heap.insert(5);
        heap.insert(9);


        System.out.println(heap.heapSort().toString());
    }
    
}
