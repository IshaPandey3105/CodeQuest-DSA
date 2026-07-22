import java.util.ArrayList;

public class J009_DirectedCycleDFS {

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int neigh : adj.get(node)) {

            // Not visited
            if (!vis[neigh]) {
                if (dfs(neigh, adj, vis, pathVis))
                    return true;
            }

            // Visited and present in current DFS path
            else if (pathVis[neigh]) {
                return true;
            }
        }

        // Backtracking
        pathVis[node] = false;

        return false;
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Directed Graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Cycle
        adj.get(4).add(5);

        if (isCycle(V, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}