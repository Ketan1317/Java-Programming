public class stringss {
    public static String removeChar(String s, char ch, String ans, int idx) {
        if (idx == s.length())
            return ans;
        if (s.charAt(idx) == ch) {
            return removeChar(s, ch, ans, idx + 1);
        }
        ans = ans + s.charAt(idx);
        return removeChar(s, ch, ans, idx + 1);
    }

    public static boolean checkPal(String s, int i) {
        if (i >= s.length()/2)
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;


        return checkPal(s, i+1);

    }

    public static void main(String[] args) {
        // System.out.println(removeChar("Hihahahhihaha", 'a', "",0));
        System.out.println(checkPal("MADAM", 0));
    }

}
