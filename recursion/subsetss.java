import java.util.*;

public class subsetss {

    public static List<List<Integer>> genSetsWithoutDuplicates(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        Arrays.sort(arr);

        int start;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            start = 0;

            // if current element is same as previous → only extend subsets
            // created in previous iteration
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;

            for (int j = start; j <= end; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]); 
                outer.add(inner);
            }
        }

        return outer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(genSetsWithoutDuplicates(arr));
    }
}
