public class J03_Derangements {
    public static void main(String[] args) {
        int n = 4;
        int der1 = Derangements(n);
        System.out.println("The number of derangements for " + n + " items is: " + der1);
        int der2 = DerangementsMemoization(n, new int[n + 1]);
        System.out.println("The number of derangements for " + n + " items is: " + der2);
        int der3 = DerangementsTabulation(n);
        System.out.println("The number of derangements for " + n + " items is: " + der3);
    }
// Brute Force Approach ::: tc O(2^n) sc O(n)
    public static int Derangements(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // explanation: we have n-1 choices for the first item, now we have two cases:
        // Derangements(n - 1) → case where things continue as a chain
        // Derangements(n - 2) → case where a pair (swap) is formed
        return (n - 1) * (Derangements(n - 1) + Derangements(n - 2)); 
    }
// Memoization Approach ::: tc O(n) sc O(n)
    public static int DerangementsMemoization(int n, int[] memo) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = (n - 1) * (DerangementsMemoization(n - 1, memo) + DerangementsMemoization(n - 2, memo));
        return memo[n];
    }
// Tabulation Approach ::: tc O(n) sc O(n)
    public static int DerangementsTabulation(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
