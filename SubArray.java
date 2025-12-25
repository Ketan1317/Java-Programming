
import java.util.ArrayList;

public class SubArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(443);
        arr.add(342554);
        arr.add(45);
        arr.add(78);
        arr.add(22);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int j = i;j < arr.size(); j++) {
                inner.add(arr.get(j));
            }

            res.add(inner);

        }


        System.out.println(res.toString());

    }
}
