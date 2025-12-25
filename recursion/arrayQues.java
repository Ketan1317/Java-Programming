
public class arrayQues {
    public static boolean isSorted(int[] arr, int idx) {
        if (idx == arr.length - 1)
            return true;

        return arr[idx] <= arr[idx + 1] && isSorted(arr, idx + 1);

    }

    public static int linearSearch(int[] arr, int idx, int target) {
        if (idx == arr.length)
            return -1;
        if (arr[idx] == target)
            return idx;
        return linearSearch(arr, idx + 1, target);
    }

    public static int rotatedBinarySearch(int[] arr, int target, int s, int e) {
        if (s > e)
            return -1;

        int mid = s + (e - s) / 2;

        if (arr[mid] == target)
            return mid;

        // Left side sorted
        if (arr[s] <= arr[mid]) {
            if (target >= arr[s] && target <= arr[mid]) {
                return rotatedBinarySearch(arr, target, s, mid - 1);
            } else {
                return rotatedBinarySearch(arr, target, mid + 1, e);
            }
        }

        // Right side sorted
        if (target >= arr[mid] && target <= arr[e]) {
            return rotatedBinarySearch(arr, target, mid + 1, e);
        }

        return rotatedBinarySearch(arr, target, s, mid - 1);

    }

    public static void bubble(int[] arr, int r, int c) {
        if (r == 0)
            return;

        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, r, c + 1);
        } else {
            bubble(arr, r - 1, 0);
        }
    }

    public static void insertion(int[] arr, int r, int c) {
    // r = index of element we're inserting
    if (r == arr.length) return; // finished sorting

    // We are shifting arr[c] backwards until it reaches correct position
    if (c > 0 && arr[c] < arr[c - 1]) {
        int temp = arr[c];
        arr[c] = arr[c - 1];
        arr[c - 1] = temp;
        insertion(arr, r, c - 1); // keep shifting left
    } else {
        // element placed correctly → move to next index
        insertion(arr, r + 1, r + 1);
    }
}


    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 1, 2, 3, 4, };
        // System.out.println(isSorted(arr,0));
        System.out.println(rotatedBinarySearch(arr, 5, 0, arr.length - 1));
        insertion(arr, 0, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
