// Topics we have done in this file :-
// 1. Implementation of tree
// 2. Display of tree
// 3. Sum of all nodes
// 4. Product and nonzero product 
// 5. Finding Max and Min node
// 6. calculating Size of tree (no of nodes)
// 7. Finding level and Height of Binary tree

class TNode{
    int val;
    TNode left;
    TNode right;
    TNode(int val){
        this.val=val;
        // this.left=null;    // optional
        // this.right=null;
    }
}

public class J001_TreesBasics {

    public static void main(String[] args) {

        // Implementation of tree
        TNode root = new TNode(50);
        TNode A = new TNode(1);     //    root
        TNode B = new TNode(2);     //  A       B
        TNode C = new TNode(3);    // C       D    E
        TNode D = new TNode(4);
        TNode E = new TNode(0);
        root.left=A;
        root.right=B;
        A.left=C;
        B.left=D;
        B.right=E;
        System.out.println(root);
        System.out.println(A.left.val);
        A.left.val=100;
        System.out.println(root.left.left.val);
        System.out.println(D.left+"\n");  // null

        // displaying tree nodes 
        display(root);
        System.out.println();

        // sum of tree nodes
        System.out.println(sum(root));

        // product of tree nodes
        System.out.println(product(root));
        System.out.println(NonZeroproduct(root));

        // Finding Max and Min node
        System.out.println(Max(root));
        System.out.println(min(root));

        // calculating Size of tree (no of nodes)
        System.out.println(size(root));

        // Finding level of Binary tree
        int l=level(root);
        System.out.println("level:"+l);
        int h=l-1;
        System.out.println("Height:" + h);
    }

    public static void display(TNode temp){
        if(temp==null) return;  // base case
        System.out.print(temp.val + " ");   // root
        display(temp.left);  // left subtree
        display(temp.right);  // right subtree
    }

    public static int sum(TNode temp){
        if(temp==null) return 0;  // base case   
        return temp.val + sum(temp.left) + sum(temp.right) ;
    }

    public static int product(TNode temp){
        if(temp==null) return 1;  // base case   
        return temp.val * product(temp.left) * product(temp.right) ;
    }

    public static int NonZeroproduct(TNode temp){
        if(temp==null) return 1;  // base case
        // if(temp.val==0) temp.val = 1;   //This changes the actual tree
        // return temp.val * NonZeroproduct(temp.left) * NonZeroproduct(temp.right) ;

        int val = (temp.val == 0) ? 1 : temp.val;
        return val * NonZeroproduct(temp.left) * NonZeroproduct(temp.right) ;

    }

    public static int Max(TNode temp) {
        // base case
        if (temp == null) return Integer.MIN_VALUE;

        // get max from left and right subtree
        int leftMax = Max(temp.left);
        int rightMax = Max(temp.right);

        // return max of current, left, right
        return Math.max(temp.val, Math.max(leftMax, rightMax));
    }

    public static int min(TNode temp) {
        // base case
        if (temp == null) return Integer.MAX_VALUE;

        // get max from left and right subtree
        int leftMax = min(temp.left);
        int rightMax = min(temp.right);

        // return max of current, left, right
        return Math.min(temp.val, Math.min(leftMax, rightMax));
    }

    public static int size(TNode temp){
        if(temp==null) return 0;  // base case   
        return 1 + size(temp.left) + size(temp.right) ;
    }

    public static int level(TNode temp){
        if(temp==null) return 0;  // base case   
        return 1 +  Math.max(level(temp.left) , level(temp.right)) ;
    }

}
