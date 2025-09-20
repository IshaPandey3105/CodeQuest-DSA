import java.util.*;

public class J08_SmallestDivisor {

    // Function to check if 'mid' can be a valid divisor
    public static boolean isPossible(int[] arr, int threshold, int mid) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] + mid - 1) / mid; // same as ceil(arr[i]/mid)
        }
        return sum <= threshold;
    }

    // Function to find the smallest divisor
    public static int smallestDivisor(int[] arr, int threshold) {
        int max = Arrays.stream(arr).max().getAsInt(); // maximum element in arr
        int start = 1, end = max;
        int div = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, threshold, mid)) {
                div = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return div;
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9}; // example array
        int threshold = 6;          // example threshold

        int result = smallestDivisor(arr, threshold);
        System.out.println("The smallest divisor is: " + result);
    }
}
