import java.util.ArrayList;

public class J002_BFS {

    public static void bfsTraversal(int[][] adj, int vertices, int startVertex) {
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> queue = new ArrayList<>();

        // Mark the starting vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int currentVertex = queue.remove(0);
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int i = 0; i < vertices; i++) {
                if (adj[currentVertex][i] == 1 && !visited[i]) {
                    // If an adjacent vertex has not been visited, mark it and enqueue it
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        // Create a simple graph using an adjacency matrix representation
        int vertices = 5; // Number of vertices in the graph
        int[][] adj;
        adj= new int[][] {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };

        // Perform BFS traversal starting from vertex 0
        System.out.println("BFS Traversal of the Graph starting from vertex 0:");
        bfsTraversal(adj, vertices, 0);
    }
}
