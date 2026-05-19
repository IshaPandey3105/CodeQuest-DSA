class J04_Knapsack{
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int n = weights.length;

        // Brute Force Approach
        int maxValueBruteForce = knapsackBruteForce(0,weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack (Brute Force): " + maxValueBruteForce);

        // Memoization Approach
        int[][] memo = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                memo[i][j] = -1; 
            }
        }
        int maxValueMemoization = knapsackMemoization(0,weights, values, capacity, n, memo);
        System.out.println("Maximum value in Knapsack (Memoization): " + maxValueMemoization);

        // Tabulation Approach
        int maxValueTabulation = knapsackTabulation(0,weights, values, capacity);
        System.out.println("Maximum value in Knapsack (Tabulation): " + maxValueTabulation);
    }
    // Brute Force Approach using take and leave strategy
    public static int knapsackBruteForce(int i,int[] weights, int[] values, int capacity, int n) {
        if(i==weights.length) return 0;
        int skip = knapsackBruteForce(i+1,weights, values, capacity, n);
        if(weights[i]>capacity) return skip;
        int take = values[i] + knapsackBruteForce(i+1,weights, values, capacity-weights[i], n);
        return Math.max(skip,take);        
    }
    // Memoization Approach
    public static int knapsackMemoization(int i,int[] weights, int[] values, int capacity, int n, int[][] memo) {
        if(i==weights.length) return 0;
        if(memo[i][capacity]!=-1) return memo[i][capacity];
        int skip = knapsackMemoization(i+1,weights, values, capacity, n, memo);
        if(weights[i]>capacity) return memo[i][capacity] = skip;
        int take = values[i] + knapsackMemoization(i+1,weights, values, capacity-weights[i], n, memo);
        return memo[i][capacity] = Math.max(skip,take);
    }
    // Tabulation Approach
    public static int knapsackTabulation(int i,int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0; 
        }
        for (int i1 = 1; i1 <= n; i1++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i1][j] = dp[i1 - 1][j]; 
                if (weights[i1 - 1] <= j) {
                    dp[i1][j] = Math.max(dp[i1][j], values[i1 - 1] + dp[i1 - 1][j - weights[i1 - 1]]);
                }
            }
        }
        return dp[n][capacity];
    }
}