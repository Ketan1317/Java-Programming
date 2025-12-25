
import java.util.*;

public class MergeAndQuick{

    static void mergeSort(ArrayList<Integer> list, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSort(list, s, m);
        mergeSort(list, m + 1, e);

        merge(list, s, m, e);
    }

    static void merge(ArrayList<Integer> list, int s, int m, int e) {
        int l = m - s + 1;
        int r = e - m;

        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            listLeft.add(list.get(s + i));
        }
        for (int i = 0; i < r; i++) {
            listRight.add(list.get(m + 1 + i));
        }

        int i = 0, j = 0, k = s;

        while (i < l && j < r) {
            if (listLeft.get(i) <= listRight.get(j)) {
                list.set(k, listLeft.get(i));
                i++;
            } else {
                list.set(k, listRight.get(j));
                j++;
            }
            k++;
        }

        while (i < l) {
            list.set(k, listLeft.get(i));
            i++;
            k++;
        }

        while (j < r) {
            list.set(k, listRight.get(j));
            j++;
            k++;
        }
    }

    static int givePivot(ArrayList<Integer> list, int s, int e) {
        int pivot = list.get(s);

        int c = 0;
        for (int i = s + 1; i <= e; i++) {
            if (list.get(i) <= pivot) {
                c++;
            }
        }

        int correct = s + c;

        Collections.swap(list, s, correct);

        int i = s;
        int j = e;
        while (i < correct && j > correct) {
            while (list.get(i) <= pivot) {
                i++;
            }
            while (list.get(j) >= pivot) {
                j--;
            }

            if (i < correct && j > correct) {
                Collections.swap(list, i, j);
                i++;
                j--;
            }
        }

        return correct;

    }

    static void quickSort(ArrayList<Integer> list, int s, int e) {
        if (s >= e) {
            return;
        }

        int pivot = givePivot(list, s, e);

        quickSort(list, s, pivot - 1);
        quickSort(list, pivot + 1, e);
    }

    public static void main(String[] args) {
        int arr[] = {4, 46, 3, 34, 7, 854, 42};
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        quickSort(list, 0, list.size() - 1);

        System.out.println("Sorted List: " + list);
    }
}
