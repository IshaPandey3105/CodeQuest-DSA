import java.util.Arrays;

public class J1_Basic {
    public static void main(String[] args) {
        int[] arr= new int[5];
        // int[] arr1= {1,2,3,4,5};
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[4]=40;
        // arr[5]=50;   // Out of Bound
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i]<30){
                System.out.print(arr[i] + " ");
            }
        }

        // For Each loop
        for(int n:arr){
            System.out.print(n+" ");
        }

        // Finding Second Largest 
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                smax = max;   // update second max before max
                max = arr[i];
            } else if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }

        System.out.println("\nSecond Largest: " + smax);

        // Next greatest elem
        int[] nums = {12,34,52,34,100,40,57,56};
        int[] ans = new int[nums.length];

        // for(int i=0;i<nums.length;i++){
        //     int m=Integer.MIN_VALUE;
        //     for(int j=i+1;j<nums.length;j++){
        //         m=Math.max(m,nums[j]);
        //     }
        //     if (m == Integer.MIN_VALUE) {
        //         ans[i] = -1;   // no element on the right
        //     } else {
        //         ans[i] = m;
        //     }
        // }
        int maxSoFar = -1;  // last element has no right
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = maxSoFar;
            if (nums[i] > maxSoFar) {
                maxSoFar = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(ans));

        
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void change(int[] x){
        x[2]=100;
    }
}
