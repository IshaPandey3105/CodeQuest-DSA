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

// memoization

public class J05_Subsetsum {

    public static void main(String[] args) {

        int[] arr = {0,8,5,2,4};

        int target = 9;

        Boolean[][] dp =
            new Boolean[arr.length][target+1];

        System.out.println(
            fn(0, arr, target, dp)
        );
    }

    public static boolean fn(int i,
                             int[] arr,
                             int t,
                             Boolean[][] dp){

        // base case
        if(t == 0){
            return true;
        }

        if(i == arr.length){
            return false;
        }

        // already computed
        if(dp[i][t] != null){
            return dp[i][t];
        }

        // skip
        boolean leave =
            fn(i+1, arr, t, dp);

        // take
        boolean take = false;

        if(t-arr[i] >= 0){

            take =
                fn(i+1,
                   arr,
                   t-arr[i],
                   dp);
        }

        return dp[i][t] =
               (leave || take);
    }
}