import java.util.*;

class Pair {
    int node, wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Triplet {
    int node, parent, wt;

    Triplet(int node, int parent, int wt) {
        this.node = node;
        this.parent = parent;
        this.wt = wt;
    }
}

public class J013_PrimsAlgo {

    public static List<Triplet> prims(int V, List<List<Pair>> adj) {

        PriorityQueue<Triplet> pq =
                new PriorityQueue<>((a, b) -> a.wt - b.wt);

        boolean[] vis = new boolean[V];
        List<Triplet> mst = new ArrayList<>();

        pq.offer(new Triplet(0, -1, 0));

        while (!pq.isEmpty()) {

            Triplet curr = pq.poll();

            if (vis[curr.node]) continue;

            vis[curr.node] = true;

            if (curr.parent != -1)
                mst.add(curr);

            for (Pair it : adj.get(curr.node)) {
                if (!vis[it.node]) {
                    pq.offer(new Triplet(it.node, curr.node, it.wt));
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Undirected Graph
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));

        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));

        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));

        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));

        adj.get(2).add(new Pair(4, 7));
        adj.get(4).add(new Pair(2, 7));

        List<Triplet> mst = prims(V, adj);

        int totalWt = 0;

        System.out.println("MST Edges:");

        for (Triplet t : mst) {
            System.out.println(t.parent + " -> " + t.node + " : " + t.wt);
            totalWt += t.wt;
        }

        System.out.println("Total Weight = " + totalWt);
    }
}