public class reverse {
    public static void main(String[] args) {
        System.out.println(countSteps(5, 0));
    }

    private static int revInt(int ans,int n) {
        if(n==0) return ans;
        int mod = n%10;
        return revInt(ans*10+mod,n/10);
    }

    private static int countSteps(int num,int steps){
        if(num == 0) return steps;
        if(num%2 == 0){
            return countSteps(num/2,steps+1);
        }
        return countSteps(num-1,steps+1);
    }
}
