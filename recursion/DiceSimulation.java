public class DiceSimulation {
    public static void main(String[] args) {
        makeCombi("", 7);
    }

    private static void makeCombi(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            makeCombi(p+i,target-i);
        }
    }
}
