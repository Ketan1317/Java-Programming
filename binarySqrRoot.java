public class binarySqrRoot {
    public static void main(String[] args) {
        int n = 40;
        int precision = 13;

        System.out.println(sqrRoot(n, precision));
    }

    // Method to find square root using binary search + precision handling
    static double sqrRoot(int num, int precision) {

        double s = 0;              // Start of binary search range
        double e = num;            // End of binary search range
        double m = 0;             
        double rootAns = 0.0;      

        // Binary search for integer part of square root
        while (s <= e) {
            m = s + (e - s) / 2;    // Avoids overflow more than (s+e)/2

            if (m * m == num) {     // Exact square found
                return m;
            } else if (m * m > num) {
                e = m - 1;          // Move left
            } else {
                s = m + 1;          // Move right
            }
        }

        // When loop ends, 'm' is close to sqrt
        rootAns = e;  // e is floor value of sqrt

        // Add decimal precision using incremental search
        double inc = 0.1;
        for (int i = 0; i < precision; i++) {
            while (rootAns * rootAns <= num) {
                rootAns += inc;
            }
            rootAns -= inc;  // Step back once it crosses the sqrt
            inc /= 10;       // Move precision from 0.1 -> 0.01 -> 0.001
        }

        return rootAns;
    }
}
