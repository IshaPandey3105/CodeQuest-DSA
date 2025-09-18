import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J07_kclosests {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int start=0; int end=n-1;
        List<Integer> nums= new ArrayList<>(k);


        // Base cases
        // x is smaller than all elements
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) nums.add(arr[i]);
            return nums;
        }
        // x is larger than all elements
        if (x >= arr[n - 1]) {
            for (int i = n - k; i < n; i++) nums.add(arr[i]);
            return nums;
        }
        // we need the whole array
        if (k == n) {
            for (int val : arr) nums.add(val);
            return nums;
        }

        // lower bound
        int lb=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<=x) {lb=mid; start=mid+1;}
            else end=mid-1;
        }
        int i=lb; int j=lb+1;
        while (i >= 0 && j < n && k > 0) {
        if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
            nums.add(arr[i]);
            i--;
        } else {
            nums.add(arr[j]);
            j++;
        }
        k--;
    }

    // if left side still has elements
    while (i >= 0 && k > 0) {
        nums.add(arr[i]);
        i--;
        k--;
    }

    // if right side still has elements
    while (j < n && k > 0) {
        nums.add(arr[j]);
        j++;
        k--;
    }

    Collections.sort(nums);
    return nums;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5};
        // int[] arr = {1,2,3,4,5};
        int k=4;   // k no. of closests
        int x=-1;   // x is the target no.

        List<Integer> result = findClosestElements(arr, k, x);
        System.out.println("Closest elements: " + result);
    }
}
