public class J08_SmallestDivisor {

    public static int smallestDivisor(int[] arr, int threshold) {
        int n = arr.length;

        // find maximum element in array
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }

        int div = -1;
        int start = 1, end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if(arr[i]%mid==0) sum +=arr[i]/mid;
                else sum +=arr[i]/mid +1 ;
                // or with ceil division
                // sum += (arr[i] + mid - 1) / mid;
            }

            if (sum <= threshold) {
                div = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return div;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;

        int result = smallestDivisor(arr, threshold);
        System.out.println("Smallest Divisor = " + result);
    }
}
