public class mathss {
    public static void main(String[] args) {
        int n = 36;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " "); // use print to keep them on the same line

                if (i != n / i) { // print the corresponding factor n/i, if different
                    System.out.print((n / i) + " ");
                }
            }
        }
    }
}
