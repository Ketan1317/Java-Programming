public class binaryExpo{
    static final long MOD = 1_000_000_007;

    public static long findPower(long base, long p) {
        if (p == 0) return 1;

        long half = findPower(base, p / 2);
        long res = (half * half) % MOD;

        if (p % 2 == 1) {
            res = (res * base) % MOD;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPower(20, 10));
    }
}
