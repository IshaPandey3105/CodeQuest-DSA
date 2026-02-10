// J04_TopViewBT.java
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Pair {
    Node node;
    int hd;   // horizontal distance

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}

public class J05_TopViewBT {

    public static void topView(Node root) {
        if (root == null) return;

        // hd -> first node data
        HashMap<Integer, Integer> map = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int minHD = 0, maxHD = 0;

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            Node n = curr.node;
            int hd = curr.hd;

            // store only first node seen at this hd
            if (!map.containsKey(hd)) {
                map.put(hd, n.data);
            }

            if (n.left != null)
                q.add(new Pair(n.left, hd - 1));

            if (n.right != null)
                q.add(new Pair(n.right, hd + 1));

            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);
        }

        // print from leftmost to rightmost
        for (int i = minHD; i <= maxHD; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
               \   / \
                4 5   6
        Top view → 2 1 3 6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        topView(root);
    }
}
