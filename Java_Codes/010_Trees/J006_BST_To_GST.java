import java.util.ArrayList;

// Definition for a binary tree node
class Treenode {
    int val;
    Treenode left, right;
    Treenode(int val) {
        this.val = val;
    }
}

public class J006_BST_To_GST {

    /* =====================================================
       Approach 1: Brute Force using ArrayList
       -----------------------------------------------------
       Time Complexity  : O(n)
       Space Complexity : O(n)
       ===================================================== */

    public static void reverseInorder1(Treenode root, ArrayList<Treenode> list) {
        if (root == null) return;
        reverseInorder1(root.right, list);
        list.add(root);
        reverseInorder1(root.left, list);
    }

    public static Treenode bstToGst_Approach1(Treenode root) {
        if (root == null) return root;

        ArrayList<Treenode> list = new ArrayList<>();
        reverseInorder1(root, list);

        for (int i = 1; i < list.size(); i++) {
            list.get(i).val += list.get(i - 1).val;
        }
        return root;
    }

    /* =====================================================
       Approach 2: Optimized Reverse Inorder Traversal
       -----------------------------------------------------
       Time Complexity  : O(n)
       Space Complexity : O(h)
       ===================================================== */

    static int prevSum;

    public static void reverseInorder2(Treenode root) {
        if (root == null) return;

        reverseInorder2(root.right);
        prevSum += root.val;
        root.val = prevSum;
        reverseInorder2(root.left);
    }

    public static Treenode bstToGst_Approach2(Treenode root) {
        prevSum = 0;
        reverseInorder2(root);
        return root;
    }

    public static void printInorder(Treenode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    /* ------------------ main (for testing) ------------------ */

    public static void main(String[] args) {
        Treenode root = new Treenode(4);     //    4
        root.left = new Treenode(1);         //  1   6
        root.right = new Treenode(6);        // 0   3
        root.left.left = new Treenode(0);
        root.left.right = new Treenode(3);

        // bstToGst_Approach1(root);
        bstToGst_Approach2(root);
        printInorder(root);
        System.out.println();
    }
}
