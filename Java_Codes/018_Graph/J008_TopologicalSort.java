import java.util.ArrayList;

public class J008_TopologicalSort {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    public static ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, result);
            }
        }

        // Reverse the result to get the correct topological order
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            topologicalOrder.add(result.get(i));
        }

        return topologicalOrder;
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }

        result.add(node);
    }
    public static void main(String[] args) {
        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        // 5 --> 2 --> 3
        // |     |
        // v     v
        // 0     1
        // |
        // v
        // 4

        addEdge(adj, 5, 2);
        addEdge(adj, 5, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        ArrayList<Integer> result = topologicalSort(V, adj);

        System.out.println("Topological Sort: " + result);
    }
}
