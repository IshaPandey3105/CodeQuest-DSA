public class J09_MCM{
    // TC = O(2^n) and SC = O(n) for recursive approach
    // TC = O(n^3) and SC = O(n^2) for DP approach 
    // becuze 2d array is used for storing the results of subproblems and for each cell we are doing O(n) work to calculate the minimum cost by placing parenthesis at different positions.
    // n^2 due to the 2D dp array and n due to the loop that iterates through possible positions to place parenthesis.

    public static int costMCM(int arr[][], int i, int j) {
        // Base case: 1 matrix remaining, requires 0 multiplications
        if (i == j) return 0;
        
        int minCost = Integer.MAX_VALUE;
        
        // Place parenthesis at all possible positions and recursively calculate costs
        for (int k = i; k < j; k++) {
            // Cost of multiplying the sub-chains + cost of multiplying the 2 result matrices
            int x = arr[i][0] * arr[k][1] * arr[j][1];
            int cost = costMCM(arr, i, k) + costMCM(arr, k + 1, j) + x;
            
            // Update minimum cost if current cost is lower
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    // Alternative method using dimensions array
    public static int costMCM1(int arr[], int i, int j) {
        // Base case: 1 matrix remaining, requires 0 multiplications
        if (i == j) return 0;
        
        int minCost = Integer.MAX_VALUE;
        
        // Place parenthesis at all possible positions and recursively calculate costs
        for (int k = i; k < j; k++) {
            // Cost of multiplying the sub-chains + cost of multiplying the 2 result matrices
            int x = arr[i] * arr[k + 1] * arr[j + 1];
            int cost = costMCM1(arr, i, k) + costMCM1(arr, k + 1, j) + x;
            
            // Update minimum cost if current cost is lower
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    // Dynamic Programming approach
    // 1. memoization (top-down) approach
    public static int costMCM_DP(int arr[], int dp[][], int i, int j) {
        // Base case: 1 matrix remaining, requires 0 multiplications
        if (i == j) return 0;
        
        // Check if the result is already computed
        if (dp[i][j] != 0) return dp[i][j];
        
        int minCost = Integer.MAX_VALUE;
        
        // Place parenthesis at all possible positions and recursively calculate costs
        for (int k = i; k < j; k++) {
            // Cost of multiplying the sub-chains + cost of multiplying the 2 result matrices
            int x = arr[i] * arr[k + 1] * arr[j + 1];
            int cost = costMCM_DP(arr, dp, i, k) + costMCM_DP(arr, dp, k + 1, j) + x;
            
            // Update minimum cost if current cost is lower
            minCost = Math.min(minCost, cost);
        }
        
        // Store the computed result in dp array
        dp[i][j] = minCost;
        return minCost;
    }
    // 2. tabulation (bottom-up) approach
    static int costMCM_DP_Tabulation(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n-1][n-1];
        
        // Fill the dp table
        for (int i = n- 2; i >= 0; i--) { // length of the chain
            for (int j = i + 1; j <= n-2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[0][n - 2]; // Minimum cost for multiplying matrices from index 0 to n-2
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{3,4}};
        int[] arr1 = {1,2,3,4}; 
        int n = arr.length;
        int n1 = arr1.length;
        System.out.println("Minimum cost of matrix chain multiplication is " + costMCM(arr, 0 , n - 1));
        System.out.println("Minimum cost of matrix chain multiplication is " + costMCM1(arr1, 0 , n1 - 2));
        // now using dp 
        int[][] dp = new int[n][n]; 
        System.out.println("Minimum cost of matrix chain multiplication is " + costMCM_DP(arr1, dp, 0 , n1 - 2));
        System.out.println("Minimum cost of matrix chain multiplication is " + costMCM_DP_Tabulation(arr1));
    }
}