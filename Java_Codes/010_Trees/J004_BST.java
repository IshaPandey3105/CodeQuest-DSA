public class J004_BST {
    public static void main(String[] args) {
        // Implementation of tree
        TNode root = new TNode(10);
        TNode A = new TNode(5);     //          root(10)
        TNode B = new TNode(15);     //    A(5)            B(15)
        TNode C = new TNode(2);    // C(2)    F(9)     D(12)       E(20)
        TNode D = new TNode(12);
        TNode E = new TNode(20);
        TNode F = new TNode(9);
        root.left=A;
        root.right=B;
        A.left=C;
        A.right=F;
        B.left=D;
        B.right=E;
        System.out.println(min(root));
        System.out.println(max(root));
        System.out.println(Min(root));
        System.out.println(Max(root));

        TNode root1 = null;  // null tree
        System.out.println(min(root1));
        System.out.println(Min(root1));
    }
    // Recursive Approach
    public static int min(TNode root){
        if (root == null) {
            // Base case: an empty tree
            return Integer.MAX_VALUE;
        }
        if(root.left==null) return root.val;
        return min(root.left);
    }
    public static int max(TNode root){
        if (root == null) {
            // Base case: an empty tree
            return Integer.MIN_VALUE;
        }
        if(root.right==null) return root.val;
        return max(root.right);
    }
    // Iterative Approch
    public static int Min(TNode root) {
        if (root == null)
            throw new IllegalArgumentException("BST is empty");

        while (root.left != null)
            root = root.left;

        return root.val;
    }

    public static int Max(TNode root) {
        if (root == null)
            throw new IllegalArgumentException("BST is empty");

        while (root.right != null)
            root = root.right;

        return root.val;
    }
}
class TNode{
    int val;
    TNode left;
    TNode right;
    TNode(){};
    TNode(int val){
        this.val=val;
        // this.left=null;    // optional
        // this.right=null;
    }
}
