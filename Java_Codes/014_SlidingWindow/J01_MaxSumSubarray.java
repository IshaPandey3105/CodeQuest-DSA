public class J01_MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int maxSum1 = BruteForce(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSum1);
        int maxSum2 = SlidingWindow(arr, k);
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSum2);
    }
// Brute Force Approach ::: tc O(n*k) sc O(1)
    public static int BruteForce(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n - k+1; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
// Sliding Window Approach ::: tc O(n) sc O(1)
    public static int SlidingWindow(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        int i=0, j=k-1, sum=0;
        for(int x=0; x<k; x++) {
            sum+=arr[x];
        }
        i++;j++;
        maxSum = sum;
        while(j<n) {
            sum= sum-arr[i-1]+arr[j];
            maxSum = Math.max(maxSum, sum);
            i++;j++;
        }
        return maxSum;
    }
}
