public class DynamicStack extends Custom_Stack {

    // Default constructor
    public DynamicStack() {
        super(); // Calls parent constructor with default size
    }

    // Parameterized constructor
    public DynamicStack(int size) {
        super(size); // Calls parent constructor with given size
    }

    @Override
    public boolean push(int val) {
        // If stack is full → double its capacity
        if (isFull()) {
            int[] temp = new int[data.length * 2]; // create larger array

            // copy all elements to new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp; // assign new array back
        }

        // now push element normally using parent method
        return super.push(val);
    }
}
