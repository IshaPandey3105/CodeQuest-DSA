// public class J05_Subsetsum {
//     public static void main(String[] args) {
//         int[] arr ={0,8,5,2,4};
//         int target=9;
//         int[] dp = new int[arr.length];
//         System.out.println(fn(0,arr,target));
//     }
    // public static boolean fn(int i,int[] arr , int t ){
    //     if(i==arr.length){
    //         if(t==0) return true;
    //         return false;
    //     }
    //     boolean leave = fn(i+1,arr,t);
    //     if(t-arr[i] < 0) return leave; // only works for + no.
    //     boolean take = fn(i+1,arr,t-arr[i]);
    //     return  (leave || take);
    // }
// }


// Subset Sum Problem
// Find whether a subset exists with sum = target
//
// Recursion:
// At each index -> Take or Leave
//
// Memoization:
// dp[i][t] = Can we make sum t using elements from index i onwards?
// TC: O(n * target)
// SC: O(n * target) + O(n) recursion stack
//
// Tabulation:
// dp[i][j] = Can we make sum j using elements from index 0 to i ?
// leave = dp[i-1][j]
// take = dp[i-1][j-arr[i]]
// dp[i][j] = leave || take
// TC: O(n * target)
// SC: O(n * target)


// memoization

public class J05_Subsetsum {

    public static void main(String[] args) {

        int[] arr = {0, 8, 5, 2, 4};
        int target = 9;

        Boolean[][] dp = new Boolean[arr.length][target + 1];
        boolean[][] dp1 = new boolean[arr.length][target + 1];

        System.out.println(fn(0, arr, target, dp));
        System.out.println(fn2(arr, target, dp1));
    }
   public static boolean fn2(int[] arr, int t, boolean[][] dp) {

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= t) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j <= t; j++) {

                boolean leave = dp[i - 1][j];

                if (j - arr[i] < 0) {
                    dp[i][j] = leave;
                } else {

                    boolean take = dp[i - 1][j - arr[i]];

                    dp[i][j] = leave || take;
                }
            }
    }

    return dp[arr.length - 1][t];
}
    public static boolean fn(int i, int[] arr, int t, Boolean[][] dp) {

        if (i == arr.length) {
            return t == 0;
        }

        if (dp[i][t] != null) {
            return dp[i][t];
        }

        boolean leave = fn(i + 1, arr, t, dp);

        if (t - arr[i] < 0) {
            return dp[i][t] = leave;
        }

        boolean take = fn(i + 1, arr, t - arr[i], dp);

        return dp[i][t] = (leave || take);
    }
}
