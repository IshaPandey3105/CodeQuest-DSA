// J07_Longest_Common_Subsequence (LC 1143)
//
// Problem:
// Find the length of the Longest Common Subsequence (LCS) between two strings.
//
// State:
// dp[i][j] = LCS length of text1[0...i] and text2[0...j]
//
// Recurrence:
// If text1.charAt(i) == text2.charAt(j)
//     dp[i][j] = 1 + dp[i-1][j-1]
//
// Else
//     dp[i][j] = max(dp[i-1][j], dp[i][j-1])
//
// Base Case:
// If i < 0 or j < 0 -> return 0
//
// TC: O(m * n)
// SC: O(m * n) + O(m + n) recursion stack

import java.util.Arrays;

public class J07_LCS {

    public static int fn(int i, int j, String text1, String text2, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {

            dp[i][j] = 1 + fn(i - 1, j - 1, text1, text2, dp);

        } else {

            int first = fn(i, j - 1, text1, text2, dp);
            int second = fn(i - 1, j, text1, text2, dp);

            dp[i][j] = Math.max(first, second);
        }

        return dp[i][j];
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fn(m - 1, n - 1, text1, text2, dp);
    }

    // Tabulation code  TC: O(m * n) , SC: O(m * n)
    public static int lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int p = ( i>=1 && j>=1 )? dp[i-1][j-1]: 0;
                int q = ( j>=1 )? dp[i][j-1]: 0;
                int r = ( i>=1  )? dp[i-1][j]: 0;
                if(text1.charAt(i)==text2.charAt(j)) dp[i][j]= 1+p;
                else dp[i][j] = Math.max(q,r);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        int ans = longestCommonSubsequence(text1, text2);
        int ans1 = lcs(text1, text2);


        System.out.println("LCS Length = " + ans);
        System.out.println("LCS Length (Tabulation) = " + ans1);
    }
}