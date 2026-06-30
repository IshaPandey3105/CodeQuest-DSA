import java.util.ArrayList;
import java.util.List;

// TC of Permutation : O(N*N!) - This is because there are n! permutations, and for each permutation, we need to copy the current permutation to the result list, which takes O(n) time.
// SC of Permutation : O(N*N!) - The space complexity is O(n*n!) because we are storing all n! permutations, each of which has n elements.

public class J01_PandC {
    // Permutation
    public static void backtracking(List<List<Integer>> result , ArrayList<Integer> perm , int[] nums ){
        // bc
        if(perm.size() == nums.length){
            result.add(new ArrayList<Integer> (perm));
            return;
        } 
        for(int i=0 ;i<nums.length ; i++){
            if(perm.contains(nums[i])) continue;
            perm.add(nums[i]);
            backtracking(result,perm,nums);
            perm.remove(perm.size() - 1);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result , new ArrayList<>() , nums );
        return result;
    }


    // Combination
    public static void comb(List<List<Integer>> result , ArrayList<Integer> comb , int start , int n, int k ){
        // bc
        if(comb.size() == k){
            result.add(new ArrayList<Integer> (comb));
            return;
        } 
        for(int i=start ;i<=n ; i++){
            comb.add(i);
            comb(result,comb,i+1,n,k);
            comb.remove(comb.size() - 1);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        comb(result , new ArrayList<>(),1,n,k);
        return result;
    }
    
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println("Permutation::"+result);

        int n = 4;
        int k = 2;
        List<List<Integer>> result2 = combine(n, k);
        System.out.println("Combination::"+result2);
    }
}
