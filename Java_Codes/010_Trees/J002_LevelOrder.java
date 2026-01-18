import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
public class J002_LevelOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Implementation of tree
        TNode root = new TNode(1);
        TNode A = new TNode(2);     //          root(1)
        TNode B = new TNode(3);     //    A(2)            B(3)
        TNode C = new TNode(4);    // C(4)   F(5)    D(6)    E(7)
        TNode D = new TNode(6);
        TNode E = new TNode(7);
        TNode F = new TNode(5);
        root.left=A;
        root.right=B;
        A.left=C;
        A.right=F;
        B.left=D;
        B.right=E;

        // Level Order Traversal (BFS) - using queues
        // easy method (l to r)
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TNode front=q.remove();
            System.out.print(front.val + " ");
            if(front.left != null)  q.add(front.left);
            if(front.right != null) q.add(front.right);
        }

        System.out.println();

        // right to left level order
        q.add(root);
        while(!q.isEmpty()){
            TNode front=q.remove();
            System.out.print(front.val + " ");
            if(front.right != null) q.add(front.right);
            if(front.left != null)  q.add(front.left);
        }

        System.out.println();
        Print(root);
        System.out.println();

        // printing elements of nth level(0 based indx)
        // - using preorder/inorder/postorder
        System.out.print("Enter nth level: ");
        n = sc.nextInt();
        nlevel(root,0);
        System.out.println();

        // if i want to print level without using queue using dfs
        for(int x=0;x<=3;x++){  // loop to reach at every level and make n equal to that level
            n=x;
            nlevel(root, 0);
            System.out.println();
        }
        
        sc.close();
    }
    static int n;  
    public static void nlevel(TNode root,int level){
        if(root==null) return;  
        if(n==level) System.out.print(root.val);
        nlevel(root.left,level+1);
        nlevel(root.right,level+1);
    }

    //Level Order Traversal (BFS) - using queues(difficult)
    public static void Print(TNode root){
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                System.out.print(q.remove().val + " ");
                size--;
            }
            System.out.println();
        }
    }

    // public static void PrintYash(TNode root){
    //     Queue<TNode> q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null);
    //     while(!q.isEmpty()){
    //         TNode temp = q.remove();
    //         if(temp != null){
    //             if(temp.left != null){  q.add(temp.left);  }
    //             if(temp.right != null){  q.add(temp.right);  }
    //         }else if(q.isEmpty()){
    //             break;
    //         }else{
    //             q.add(null);
    //         }                
    //     }
    // }

}
