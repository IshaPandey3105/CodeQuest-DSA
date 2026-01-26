class treeNode {
    int val;
    treeNode left;
    treeNode right;

    treeNode(int val) {
        this.val = val;
    }
}

public class J009_DeletionInBST {

    public static treeNode iop(treeNode root) {
        treeNode temp = root.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public static treeNode ParentPred(treeNode root, treeNode pred) {
        if (root.left == pred || root.right == pred) return root;

        treeNode temp = root.left;
        while (temp.right != pred) {
            temp = temp.right;
        }
        return temp;
    }

    public static treeNode deleteNode(treeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {

            // case 1: no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: one child
            else if (root.left == null || root.right == null) {
                if (root.left != null) return root.left;
                return root.right;
            }

            // case 3: two children
            else {
                treeNode pred = iop(root);
                treeNode pp = ParentPred(root, pred);

                if (pp == root) {
                    pred.right = root.right;
                    return pred;
                }

                pp.right = pred.left;
                pred.left = root.left;
                pred.right = root.right;
                return pred;
            }
        }
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    // inorder traversal for testing
    public static void inorder(treeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // testing in VS Code
    public static void main(String[] args) {
        /*
              5
             /  \
            3    7
        */
        treeNode root = new treeNode(5);
        root.left = new treeNode(3);
        root.right = new treeNode(7);

        System.out.print("Before delete: ");
        inorder(root);

        root = deleteNode(root, 5);

        System.out.print("\nAfter delete: ");
        inorder(root);
    }
}
