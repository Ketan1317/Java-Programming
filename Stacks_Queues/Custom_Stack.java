public class Custom_Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public Custom_Stack() {
        this(DEFAULT_SIZE);
    }

    public Custom_Stack(int size) {
        this.data = new int[size];
    }

    public boolean push(int val) {
        if (isFull()) {
            System.out.println("Stack is already Full !!");
            return false;
        }

        ptr++;
        data[ptr] = val;
        return true;
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is Empty !!");
        }

        return data[ptr];
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Stack is Empty !!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;


    }

    public boolean isFull() {
        return ptr == data.length - 1; // ptr is at last index
    }

    public boolean isEmpty() {
        return ptr == -1;
    }
}
