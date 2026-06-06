public class J06_PartitionSS {

// Partition Equal Subset Sum (LC 416)
// Convert problem into Subset Sum = TotalSum / 2
// DP State: dp[i][j] = Can first (0...i) elements make sum j ?
// Transition:
// skip = dp[i-1][j]
// take = dp[i-1][j-nums[i]]
// dp[i][j] = take || skip
// TC: O(n * target)
// SC: O(n * target)

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {

                boolean skip = dp[i - 1][j];

                if (j - nums[i] < 0) {
                    dp[i][j] = skip;
                } else {
                    boolean take = dp[i - 1][j - nums[i]];
                    dp[i][j] = take || skip;
                }
            }
        }

        return dp[n - 1][target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        boolean ans = canPartition(nums);

        System.out.println(ans);
    }
}