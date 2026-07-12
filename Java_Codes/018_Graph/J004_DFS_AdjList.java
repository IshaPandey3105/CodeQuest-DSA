import java.util.*;

public class J004_DFS_AdjList {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);   // Remove for directed graph
    }

    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;
        System.out.print(node + " ");

        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, vis, adj);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 5);

        boolean[] vis = new boolean[V];

        dfs(0, vis, adj);
    }
}