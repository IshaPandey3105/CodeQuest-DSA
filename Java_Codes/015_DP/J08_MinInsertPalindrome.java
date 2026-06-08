// File: J08_MinimumInsertionsToMakePalindrome.java

import java.util.Arrays;

public class J08_MinInsertPalindrome {

    /*
    ========================================
    Approach 1 : LCS / LPS
    ========================================

    1. Reverse the string.
    2. Find LCS(original, reverse).
    3. LCS(original, reverse) = Longest Palindromic Subsequence (LPS).
    4. Minimum Insertions = n - LPS.

    TC: O(n^2)
    SC: O(n^2)
    */

    public static int lcs(int i, int j, String s, String r, int[][] dp) {

        if(i == s.length() || j == r.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == r.charAt(j)) {
            return dp[i][j] = 1 + lcs(i + 1, j + 1, s, r, dp);
        }

        return dp[i][j] = Math.max(
                lcs(i + 1, j, s, r, dp),
                lcs(i, j + 1, s, r, dp)
        );
    }

    public static int minInsertionsLCS(String s) {

        String r = new StringBuilder(s).reverse().toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lps = lcs(0, 0, s, r, dp);

        return n - lps;
    }


    /*
    ========================================
    Approach 2 : Direct Palindrome DP
    ========================================

    State:
    dp[i][j] = minimum insertions needed to make
    substring s[i...j] a palindrome.

    If s[i] == s[j]:
        dp[i][j] = dp[i+1][j-1]

    Else:
        dp[i][j] = 1 + min(
                        dp[i+1][j],
                        dp[i][j-1]
                   )

    TC: O(n^2)
    SC: O(n^2)
    */

    public static int solve(int i, int j, String s, int[][] dp) {

        if(i >= j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s, dp);
        }

        return dp[i][j] = 1 + Math.min(
                solve(i + 1, j, s, dp),
                solve(i, j - 1, s, dp)
        );
    }

    public static int minInsertionsDirect(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s, dp);
    }

    public static void main(String[] args) {

    String s = "mbadm";

    System.out.println("LCS Approach    : " + minInsertionsLCS(s));
    System.out.println("Direct Approach : " + minInsertionsDirect(s));
}
}