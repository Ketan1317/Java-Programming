import java.util.*;

public class permutations {
    public static void main(String[] args) {
        System.out.println(cntPermu("","q1oiuytrew"));
    }

    public static void permu(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permu(f+ch+s,up.substring(1));
        }
    }

    public static ArrayList<String> permutation(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutation(f+ch+s,up.substring(1)));
        }

        return ans;
    }


    public static int cntPermu(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int cnt = 0;
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            cnt += cntPermu(f+ch+s,up.substring(1));
        }

        return cnt;
    }
}
