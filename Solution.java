public class Solution {
    public static void main(String[] args) {
        
    }

    public static int func(int[] arr){
        int cnt = 0;
        for(int i=0;i<arr.length-1;i++){
            int key = i+1;
            for(int j=key;j>=0;j--){
               if(arr[j] > arr[j+1]){
                swap(arr,j,j+1);
                cnt++;
               }
            }

        }

        return cnt;
    }
}


int n = big;
int m = small;

for(int i=0 -> = n-m){
    if(small.regionMatches(i,big,i,n)){
        boolean left = (i == 0 || big.charAt(i) != )
        boolean rifht =(i +m== n || big.charaAT)i+m-1)
    }
}
