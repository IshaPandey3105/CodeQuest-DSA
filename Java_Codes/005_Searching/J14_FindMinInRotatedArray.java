public class J14_FindMinInRotatedArray {

    public static int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        // TC = O(log n) average, O(n) worst case

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If start, mid, end are equal, we can't decide which side is sorted
            // Reduce search space by moving both pointers inward
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // If mid element is greater than end, minimum is in the right half
            else if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // Otherwise, minimum is in the left half including mid
            else {
                end = mid;
            }
        }
        return nums[start];  // start == end points to the minimum
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 2, 2, 0, 1};
        int[] nums3 = {1, 3, 5};

        System.out.println("Minimum in nums1: " + findMin(nums1)); // 1
        System.out.println("Minimum in nums2: " + findMin(nums2)); // 0
        System.out.println("Minimum in nums3: " + findMin(nums3)); // 1
    }
}
