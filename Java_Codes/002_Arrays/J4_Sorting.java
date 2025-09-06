import java.util.Arrays;

public class J4_Sorting {
    public static void main(String[] args) {

// sorting 0's and 1's
        //(we can also optimize it by using only 2 for loops)
        //more optimise use 2 pointers and swapping

        // METHOD 1
        int[] arr1={0,1,1,1,0,0,0,1,1};
        int zeros=0;
        for(int f =0;f<arr1.length;f++){
            if(arr1[f]==0){
                zeros++;
            }
        }
        for(int f =0;f<arr1.length;f++){
            if(f<zeros){
                arr1[f]=0;
            }
            else{
                arr1[f]=1;
            }
        }
        System.out.println(Arrays.toString(arr1));
        
        // METHOD-2

        int[] arr2 = {0,1,1,1,0,1,1,1,0,0,0,1,1};

        int left = 0;
        int right = arr2.length - 1;

        while (left < right) {
            // if left is already 0, move ahead
            if (arr2[left] == 0) {
                left++;
            } 
            // if right is already 1, move backward
            else if (arr2[right] == 1) {
                right--;
            } 
            // if left is 1 and right is 0 → swap
            else {
                int temp = arr2[left];
                arr2[left] = arr2[right];
                arr2[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr2));
    

// Sorting 0s, 1s , 2s

// METHOD - 1  ----- Valid Everywhere
    int[] arr3={0,1,1,1,0,0,0,1,1};
        int noOfZeros=0;
        int noOfOnes=0;
        for(int f =0;f<arr3.length;f++){
            if(arr3[f]==0){
                noOfZeros++;
            }
            else if (arr3[f] == 1) {
                noOfOnes++;
            }
        }
        for(int f =0;f<arr3.length;f++){
            if(f<noOfZeros){
                arr3[f]=0;
            }
            else if (f<noOfZeros+noOfOnes){
                arr3[f]=1;
            }
            else{
                arr3[f]=2;
            }
        }
        System.out.println(Arrays.toString(arr3));




//METHOD - 2 ---- More optimized [Dutch Flag Algo]
        int[] nums={0,1,1,1,0,0,0,1,1};
        int n=nums.length;
        int mid=0 , high=n-1 , low=0;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
