
public class stringBuilderr {

    public static void main(String[] args) {

        String name = "hello world how are you";
        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() > 1) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        System.out.println(sb.toString().trim());

    }
}
