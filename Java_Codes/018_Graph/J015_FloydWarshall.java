// import java.util.Arrays;

public class J015_FloydWarshall {

    static final int INF = (int) 1e9;

    static void floydWarshall(int[][] dist, int V) {

        // Try every vertex as an intermediate vertex
        for (int via = 0; via < V; via++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {

                    if (dist[i][via] == INF || dist[via][j] == INF)
                        continue;

                    dist[i][j] = Math.min(dist[i][j],
                            dist[i][via] + dist[via][j]);
                }
            }
        }

        // Negative Cycle Detection
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative Weight Cycle Detected!");
                return;
            }
        }

        printMatrix(dist, V);
    }

    static void printMatrix(int[][] dist, int V) {

        System.out.println("Shortest Distance Matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int V = 4;

        int[][] graph = {
                {0,   3,   INF, 7},
                {8,   0,   2,   INF},
                {5,   INF, 0,   1},
                {2,   INF, INF, 0}
        };

        floydWarshall(graph, V);
    }
}