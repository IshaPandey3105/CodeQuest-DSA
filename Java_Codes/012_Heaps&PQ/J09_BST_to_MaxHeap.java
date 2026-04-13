import java.util.*;

// Tree Node
class Nodee {
    int data;
    Nodee left, right;

    Nodee(int val) {
        data = val;
        left = right = null;
    }
}

public class J09_BST_to_MaxHeap {

    static int index = 0;
    public static void main(String[] args) {

        // Create BST
        Nodee root = new Nodee(40);
        root.left = new Nodee(20);
        root.right = new Nodee(10);
        root.left.left = new Nodee(1);
        root.left.right = new Nodee(3);
        // root.right.left = new Nodee(5);
        root.right.right = new Nodee(7);

        // List<Integer> list = new ArrayList<>();

        // Step 1: Reverse Inorder (Descending)
        // reverseInorder(root, list);
        // preorderPrint(root);

        // // Step 2: Fill using Preorder
        // fillPreorder(root, list);

        // // Print Preorder of Max Heap
        // System.out.println("\nPreorder of Max Heap:");
        // preorderPrint(root);

        // Checking if the the Binary Tree is a Max Heap
        if (isMaxHeap(root) && isComplete(root,0,size(root))) {
            System.out.println("The Binary Tree is a Max Heap.");
        } else {
            System.out.println("The Binary Tree is not a Max Heap.");
        }

    }

    // Function to check if a binary tree is a max heap
    public static boolean isMaxHeap(Nodee root) {
        if (root == null) return true;

        // Check if the current node is greater than its children
        if (root.left != null && root.data < root.left.data) return false;
        if (root.right != null && root.data < root.right.data) return false;

        // Recursively check the left and right subtrees
        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }

    // Function to check if a binary tree is complete
    public static int size(Nodee root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    public static boolean isComplete(Nodee root, int index, int totalNodes){
        if(root == null) return true;
        if(index >= totalNodes) return false;
        return isComplete(root.left, 2 * index + 1, totalNodes) && isComplete(root.right, 2 * index + 2, totalNodes);
    }

    // Reverse Inorder: Right → Root → Left
    public static void reverseInorder(Nodee root, List<Integer> list) {
        if (root == null) return;

        reverseInorder(root.right, list);
        list.add(root.data);
        reverseInorder(root.left, list);
    }

    // Fill using Preorder: Root → Left → Right
    public static void fillPreorder(Nodee root, List<Integer> list) {
        if (root == null) return;

        root.data = list.get(index++);
        fillPreorder(root.left, list);
        fillPreorder(root.right, list);
    }

    // Print Preorder
    static void preorderPrint(Nodee root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }
}