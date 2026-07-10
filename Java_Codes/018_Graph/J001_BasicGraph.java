import java.util.ArrayList;

public class J001_BasicGraph {
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
        // basic graph representation
        // 1. Adjacency Matrix Representation
        System.out.println("Adjacency Matrix Representation of the Graph:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        
        // 2. Adjacency List Representation
        System.out.println("\nAdjacency List Representation of the Graph:");
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertices);
        // Initialize the adjacency list with values from the adjacency matrix
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < vertices; j++) {
                if (adj[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        // Print the adjacency list
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int j : adjList.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
