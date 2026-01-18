import java.util.*;

class J003_RightSideView {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Function to get right side view
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        TreeNode prev = root;

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();

            if (temp != null) {
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            } 
            else if (q.isEmpty()) {
                break;
            } 
            else {
                // level finished, prev is rightmost
                list.add(prev.val);
                q.add(null);
            }

            prev = temp;
        }

        // last level
        list.add(prev.val);
        return list;
    }

    // Function to get left side view
    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        boolean isFirst = true; // marks first node of a level

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            
            if (temp != null) {
                // first node of this level
                if (isFirst) {
                    list.add(temp.val);
                    isFirst = false;
                }
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            } 
            else if (q.isEmpty()) {
                break;
            } 
            else {
                // move to next level
                isFirst = true;
                q.add(null);
            }
        }
        return list;
    }
    // main function
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \   \
              5   4
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> ans = rightSideView(root);
        List<Integer> ans1 = leftSideView(root);
        System.out.println(ans); // expected [1, 3, 4]
        System.out.println(ans1); // expected [1, 2, 5]
    }
}
