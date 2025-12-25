import java.util.*;


public class substringss {
    public static void genSubsets(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        genSubsets(p+ch, up.substring(1));
        genSubsets(p, up.substring(1));
        genSubsets(p+(ch+0), up.substring(1));
    }

    public static ArrayList<String> genrate(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> left = genrate(p+up.charAt(0), up.substring(1));
        ArrayList<String> right = genrate(p, up.substring(1));

        left.addAll(right);
        return left;

    }
    public static void main(String[] args) {
        genSubsets("", "abc");
        // System.err.println(genrate("", "abs"));

    }
}
