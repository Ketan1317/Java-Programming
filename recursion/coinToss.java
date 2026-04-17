public class coinToss {
    public static void helper(int n,StringBuilder sb){
        if(n == 0){
            System.out.println(sb.toString());
            return;
        }

        sb.append('H');
        helper(n-1,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append('T');
        helper(n-1,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public static void main(String[] args) {
        helper(10,new StringBuilder());
    }
}
