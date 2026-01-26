import java.util.ArrayList;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class J008_Balance_BST {

    /* =====================================================
       Balance a Binary Search Tree
       -----------------------------------------------------
       Time Complexity  : O(n)
       Space Complexity : O(n)
       Explanation      : Inorder traversal gives sorted list,
                          then build balanced BST using mid.
       ===================================================== */

    // Step 1: Store inorder traversal (sorted order)
    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Step 2: Build balanced BST from sorted list
    public static TreeNode buildBalancedBST(ArrayList<Integer> list, int l, int h) {
        if (l > h) return null;

        int mid = l + (h - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = buildBalancedBST(list, l, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, h);

        return root;
    }

    public static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildBalancedBST(list, 0, list.size() - 1);
    }

    /* ---------- Inorder Print (verification) ---------- */

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    /* ------------------ main ------------------ */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        root = balanceBST(root);
        printInorder(root);
        System.out.println();
    }
}
