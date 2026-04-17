import java.util.*;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        st.add(6);
        st.add(7);

        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }

    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()) return;

        int val = st.pop();
        reverse(st);               
        insertAtBottom(val, st);
    }

    public static void insertAtBottom(int val, Stack<Integer> st) {
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int temp = st.pop();
        insertAtBottom(val, st);
        st.push(temp);
    }
}
