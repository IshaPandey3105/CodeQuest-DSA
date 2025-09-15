import java.util.Arrays;

public class J02_LowerBound {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,3,4,5,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        int target=3;
        int l=0;
        int i=0 ; int j=n-1;

        // LOWER BOUND
        //  // Special checks
        // if (target < arr[0]) {
        //     l = -1; // smaller than all
        // } 
        // else if (target > arr[n - 1]) {
        //     l = n; // greater than all
        // } 
        // else {
        //     while (i <= j) {
        //         int mid = i + (j - i) / 2;
        //         if (arr[mid] >= target) {
        //             l = mid;
        //             j = mid - 1; // search left
        //         } else {
        //             i = mid + 1; // search right
        //         }
        //     }
        // }
        // System.out.println("Lower bound index: " + l);


        // UPPER BOUND
        l=n;
        target=3;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > target) { // only change
                l = mid;      // possible upper bound
                j = mid - 1;  // search further left
            } else {
                i = mid + 1;  // arr[mid] <= target → go right
            }
        }
        System.out.println("Upper bound index: " + l);
    }
}
