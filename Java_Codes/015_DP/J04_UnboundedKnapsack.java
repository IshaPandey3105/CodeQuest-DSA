public class J04_UnboundedKnapsack {

    // Memoization Approach
    public static int knapsackMemoization(int i,int[] weights, int[] values, int capacity, int n, int[][] memo) {
        if(i==weights.length) return 0;
        if(memo[i][capacity]!=-1) return memo[i][capacity];
        int skip = knapsackMemoization(i+1,weights, values, capacity, n, memo);
        if(weights[i]>capacity) return memo[i][capacity] = skip;
        int take = values[i] + knapsackMemoization(i,weights, values, capacity-weights[i], n, memo);
        return memo[i][capacity] = Math.max(skip,take);
    }
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {50, 10, 120};
        int capacity = 60;    // take 2 time 30 weight item
        int n = weights.length;

        // Memoization Approach
        int[][] memo = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                memo[i][j] = -1; 
            }
        }
        int maxValueMemoization = knapsackMemoization(0,weights, values, capacity, n, memo);
        System.out.println("Maximum value in Knapsack (Memoization): " + maxValueMemoization);
    }
}
