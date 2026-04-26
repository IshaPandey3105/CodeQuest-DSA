import java.util.Scanner;

public class J02_FriendsPairing {
    public static void main(String[] args) {
        // taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of friends: ");
        int n = sc.nextInt();
        int pair1 = FriendsPairing(n);
        System.out.println("The number of ways to pair " + n + " friends is: " + pair1);
        int pair2 = FriendsPairingMemoization(n, new int[n + 1]);
        System.out.println("The number of ways to pair " + n + " friends is: " + pair2);
        int pair3 = FriendsPairingTabulation(n);
        System.out.println("The number of ways to pair " + n + " friends is: " + pair3);
        sc.close();
    }
// Brute Force Approach ::: tc O(2^n) sc O(n)
    public static int FriendsPairing(int n) {
        if (n <= 2) {
            return n;
        }
        // single then take the remaining n-1 friends and pair them
        // pair then take the remaining n-2 friends and pair them with n-1 friends
        return FriendsPairing(n - 1) + (n - 1) * FriendsPairing(n - 2);
    }
// Memoization Approach ::: tc O(n) sc O(n)
    public static int FriendsPairingMemoization(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = FriendsPairingMemoization(n - 1, memo) + (n - 1) * FriendsPairingMemoization(n - 2, memo);
        return memo[n];
    }
// Tabulation Approach ::: tc O(n) sc O(n)
    public static int FriendsPairingTabulation(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(n>1) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    } 
}
