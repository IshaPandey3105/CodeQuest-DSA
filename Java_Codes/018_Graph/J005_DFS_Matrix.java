public class J005_DFS_Matrix {

    static void dfs(int node, boolean[] vis, int[][] graph, int V) {

        vis[node] = true;
        System.out.print(node + " ");

        // Check every possible neighbor
        for (int neigh = 0; neigh < V; neigh++) {

            if (graph[node][neigh] == 1 && !vis[neigh]) {
                dfs(neigh, vis, graph, V);
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        // Create adjacency matrix
        int[][] graph = new int[V][V];

        // Add edges
        graph[0][1] = graph[1][0] = 1;
        graph[0][2] = graph[2][0] = 1;
        graph[1][3] = graph[3][1] = 1;
        graph[1][4] = graph[4][1] = 1;
        graph[2][5] = graph[5][2] = 1;

        boolean[] vis = new boolean[V];

        dfs(0, vis, graph, V);
    }
}