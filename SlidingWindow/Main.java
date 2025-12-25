package SlidingWindow;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 1, 1, 5, 1 };
        int k = 8;

        int len = 0;

        // for (int i = 0; i < arr.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < arr.length; j++) {
        //         sum += arr[j];
        //         if(sum > k){
        //             break;
        //         }
        //         len = Math.max(len,j-i+1);
        //     }
        // }


        int l = 0;
        int r = 0;

        int sum = 0;

        while(r < arr.length){
            sum +=arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }

            if(sum <= k){
                len = Math.max(len,r-l+1);
            }

            r++;
        }

        System.out.println(len);

    }

}
