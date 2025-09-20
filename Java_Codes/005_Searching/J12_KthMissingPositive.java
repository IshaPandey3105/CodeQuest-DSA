public class J12_KthMissingPositive {

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missed = arr[mid] - (mid + 1);

            if (missed < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return k + start;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println("Kth missing number: " + findKthPositive(arr1, k1));
        // Expected: 9

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        System.out.println("Kth missing number: " + findKthPositive(arr2, k2));
        // Expected: 6
    }
}
