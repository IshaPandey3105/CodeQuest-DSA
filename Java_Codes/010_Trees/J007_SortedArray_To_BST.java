// Definition for a binary tree node
class Tree_Node {
    int val;
    Tree_Node left, right;
    Tree_Node(int val) {
        this.val = val;
    }
}

public class J007_SortedArray_To_BST {

    /* =====================================================
       Convert Sorted Array to Balanced BST
       -----------------------------------------------------
       Time Complexity  : O(n)
       Space Complexity : O(h)
       Explanation      : Middle element becomes root to
                          maintain height balance.
       ===================================================== */

    public static Tree_Node helper(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low) / 2;
        Tree_Node root = new Tree_Node(nums[mid]);

        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);

        return root;
    }

    public static Tree_Node sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /* ---------- Inorder Print (verification) ---------- */

    public static void printInorder(Tree_Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    /* ------------------ main ------------------ */

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Tree_Node root = sortedArrayToBST(nums);

        printInorder(root); // should print sorted array
    }
}
