import java.util.*;
import java.util.Stack;

public class J010_MergeTwoBST {

    // ===============================
    // Tree Node
    // ===============================
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // ===============================
    // MAIN (for VS Code run)
    // ===============================
    public static void main(String[] args) {

        // Tree 1
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(4);

        // Tree 2
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(3);

        System.out.println(getAllElements_sort(r1, r2));
        System.out.println(getAllElements_merge(r1, r2));
        System.out.println(getAllElements_stacks(r1, r2));
    }


    // =================================================
    // Common Inorder
    // =================================================
    static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    // =================================================
    // APPROACH 1 — INORDER + SORT (EASIEST)
    // =================================================
    /*
    Steps:
    - Inorder both trees
    - Put into one list
    - Sort

    TC: O((n+m) log(n+m))
    SC: O(n+m)
    */
    static List<Integer> getAllElements_sort(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        inorder(root1, ans);
        inorder(root2, ans);
        Collections.sort(ans);
        return ans;
    }


    // =================================================
    // APPROACH 2 — TWO LIST + MERGE
    // =================================================
    /*
    Steps:
    - Make two sorted inorder lists
    - Merge like merge-sort

    TC: O(n+m)
    SC: O(n+m)
    */
    static List<Integer> getAllElements_merge(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        inorder(root1, a);
        inorder(root2, b);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j))
                res.add(a.get(i++));
            else
                res.add(b.get(j++));
        }

        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));

        return res;
    }


    // =================================================
    // APPROACH 3 — TWO STACKS (BEST SPACE)
    // =================================================
    /*
    Steps:
    - Do inorder of both together
    - Use two stacks
    - Always pick smaller next node

    TC: O(n+m)
    SC: O(h1+h2)
    */
    static List<Integer> getAllElements_stacks(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {

            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().val <= s2.peek().val)) {
                TreeNode node = s1.pop();
                res.add(node.val);
                root1 = node.right;
            } else {
                TreeNode node = s2.pop();
                res.add(node.val);
                root2 = node.right;
            }
        }

        return res;
    }
}
