import java.util.*;

public class J003_BFSUsingList {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);   // Remove this line for directed graph
    }

    public static void main(String[] args) {

        int V = 6; // vertices: 0 to 5

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

        bfs(0, adj, V);
    }

    static void bfs(int start, ArrayList<ArrayList<Integer>> adj, int V) {

        boolean[] vis = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            System.out.print(node + " ");

            for (int neigh : adj.get(node)) {

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }
}