public class J13_SingleElement {

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 1, end = n - 2;

// nums = [1,2,2,3,3] → single is at index 0. Your code won’t catch it.
// nums = [1,1,2,2,3] → single is at index n-1. Same issue

        // edge cases
        if (n == 1) return nums[0];                 // single element array
        if (nums[0] != nums[1]) return nums[0];     // first element unique
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1]; // last element unique

        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;   // single is on the right
            } else {
                end = mid;         // single is on the left or at mid
            }
        }
        return nums[start];   // or nums[end], same
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2,3,3,4,4,8,8};
        int[] nums2 = {3,3,7,7,10,11,11};
        int[] nums3 = {1};

        System.out.println("Single element in nums1: " + singleNonDuplicate(nums1)); // 2
        System.out.println("Single element in nums2: " + singleNonDuplicate(nums2)); // 10
        System.out.println("Single element in nums3: " + singleNonDuplicate(nums3)); // 1
    }
}
