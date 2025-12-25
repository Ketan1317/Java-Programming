import java.util.Scanner;

public class sieveOfEratosthenes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        // Create a boolean array of size n+1
        // By default, all values are false (meaning initially all numbers are assumed prime)
        boolean[] isComposite = new boolean[n + 1];

        // Call the sieve function
        sieve(isComposite, n);

    }

    // Sieve of Eratosthenes function
    static void sieve(boolean[] isComposite, int n) {
        // Start from 2, the first prime number
        for (int i = 2; i * i <= n; i++) { 
            // If number is not yet marked as composite → it’s a prime
            if (!isComposite[i]) {
                // Mark all multiples of i as composite (non-prime)
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Print all prime numbers
        System.out.println("Prime numbers up to " + n + " are:");
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // For a clean new line after output
    }
}
