import java.util.*;

public class J002_BFS_Matrix {

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

        bfs(0, graph, V);
    }

    static void bfs(int start, int[][] graph, int V) {

        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            // Check every possible neighbor
            for (int neigh = 0; neigh < V; neigh++) {

                if (graph[node][neigh] == 1 && !vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }
}