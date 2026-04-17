public class NewtonSQRT {

    public static void main(String[] args) {
        System.out.println(sqrt(40)); 
    }

    // Function to compute square root using Newton-Raphson Method
    static double sqrt(double n) {

        double x = n;     // Initial guess (starting with the number itself)
        double root;      // This will store the improved guess

        while (true) {
            // Newton's Formula: x1 = 0.5 * (x + n/x)
            root = (x + (n / x))/2;

            // Check for desired precision:
            // If the new guess and old guess are very close, stop the loop
            if (Math.abs(root - x) < 1) { 
                break;
            }

            // Update x to the new refined value
            x = root;
        }

        return root; // Final approximate square root
    }
}
