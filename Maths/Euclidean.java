

public class Euclidean {

    // Function to calculate GCD using Euclidean Algorithm (Recursive Method)
    static int GCD(int a, int b) {

        // Base Case: If second number becomes 0, 'a' is the GCD
        if (b == 0) {
            return a;
        }

        // Recursive Call:
        // GCD(a, b) = GCD(b, a % b)
        // We reduce the problem size by replacing:
        // a -> b,  b -> remainder (a % b)
        return GCD(b, a % b);

        /*
        // Iterative Way (Same logic using loop)
        while (b != 0) {
            int rem = a % b; // Find remainder
            a = b;           // Replace a with b
            b = rem;         // Replace b with remainder
        }
        return a;   // When b becomes 0, 'a' is GCD
        */
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        // Call the GCD function and print the result
        System.out.println(GCD(num1, num2));
        // ArrayList<Integer> l = new ArrayList<>();

    }
}
