public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length; // end is at last index
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int val) {
        if (isFull()) {
            return false;
        }
        data[end++] = val;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        int removed = data[0];

        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        return data[0];
    }
}
