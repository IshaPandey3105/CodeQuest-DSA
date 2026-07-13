import java.util.*;

public class J006_CycleDetectionBFS {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {

            Pair front = q.remove();

            int node = front.node;
            int parent = front.parent;

            for (int neigh : adj.get(node)) {

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(new Pair(neigh, node));
                }
                else if (neigh != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 0--1
        // |  |
        // 3--2    4

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        boolean[] vis = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (detectCycle(i, adj, vis)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println(cycle);
    }
}