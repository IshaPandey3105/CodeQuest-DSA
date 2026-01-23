// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class J005_ValidateBST {

/* =====================================================
   1st CODE: Using max() & min() at each node
   -----------------------------------------------------
   Time Complexity  : O(n²)
   Space Complexity : O(h)
   Explanation      : For every node, we compute max of
                      left subtree and min of right subtree,
                      causing repeated traversal.
   ===================================================== */


    public static long max(TreeNode root) {
        if (root == null) return Long.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    public static long min(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;
        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }

    public static boolean isValidBST_Approach1(TreeNode root) {
        if (root == null) return true;
        if (root.val <= max(root.left)) return false;
        if (root.val >= min(root.right)) return false;
        return isValidBST_Approach1(root.left)
                && isValidBST_Approach1(root.right);
    }

/* =====================================================
   2nd CODE: Global flag with full tree traversal
   -----------------------------------------------------
   Time Complexity  : O(n)
   Space Complexity : O(h)
   Explanation      : Tree is traversed twice (max & min),
                      but each traversal is linear.
                      Logic works but is unsafe in design
                      due to global state dependency.
   ===================================================== */


    static boolean ans2;

    public static long max2(TreeNode root) {
        if (root == null) return Long.MIN_VALUE;

        long leftMax = max2(root.left);
        if (leftMax >= root.val) ans2 = false;

        long rightMax = max2(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public static long min2(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;

        long leftMin = min2(root.left);
        long rightMin = min2(root.right);
        if (rightMin <= root.val) ans2 = false;

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    public static boolean isValidBST_Approach2(TreeNode root) {
        ans2 = true;
        max2(root);
        min2(root);
        return ans2;
    }

/* =====================================================
   3rd CODE: Inorder traversal (BST property)
   -----------------------------------------------------
   Time Complexity  : O(n)
   Space Complexity : O(h)
   Explanation      : Inorder traversal of BST gives
                      strictly increasing order.
                      Most optimal and interview-preferred.
   ===================================================== */


    static TreeNode prev;
    static boolean ans3;

    public static void inorder(TreeNode root) {
        if (root == null || !ans3) return;

        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            ans3 = false;
            return;
        }
        prev = root;

        inorder(root.right);
    }

    public static boolean isValidBST_Approach3(TreeNode root) {
        prev = null;
        ans3 = true;
        inorder(root);
        return ans3;
    }

    /* ---------- main (for VS Code / testing) ---------- */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);

        System.out.println(isValidBST_Approach1(root)); // false
        System.out.println(isValidBST_Approach2(root)); // false
        System.out.println(isValidBST_Approach3(root)); // false
    }
}
