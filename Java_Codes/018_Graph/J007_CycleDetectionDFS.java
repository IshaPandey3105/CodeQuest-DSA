import java.util.*;

public class J007_CycleDetectionDFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean detectCycle(int node, int parent,
                               ArrayList<ArrayList<Integer>> adj,
                               boolean[] vis) {

        vis[node] = true;

        for (int neigh : adj.get(node)) {

            if (!vis[neigh]) {

                if (detectCycle(neigh, node, adj, vis)) {
                    return true;
                }

            } else if (neigh != parent) {
                return true;
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

                if (detectCycle(i, -1, adj, vis)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println(cycle);
    }
}