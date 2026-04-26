public class J01_Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int fib1 = Fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + fib1);
        int fib2 = FibonacciMemoization(n, new int[n + 1]);
        System.out.println("The " + n + "th Fibonacci number is: " + fib2);
        int fib3 = FibonacciTabulation(n);
        System.out.println("The " + n + "th Fibonacci number is: " + fib3);
    }
// Brute Force Approach ::: tc O(2^n) sc O(n)
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
// Memoization Approach ::: tc O(n) sc O(n)
    public static int FibonacciMemoization(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = FibonacciMemoization(n - 1, memo) + FibonacciMemoization(n - 2, memo);
        return memo[n];
    }
// Tabulation Approach ::: tc O(n) sc O(n)
    public static int FibonacciTabulation(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
