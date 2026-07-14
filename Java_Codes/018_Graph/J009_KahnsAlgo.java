import java.util.ArrayList;

public class J009_KahnsAlgo {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    public static ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove(0);
            result.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
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
        System.out.println("Topological Sort (Kahn's Algorithm): " + result);
    }
}
