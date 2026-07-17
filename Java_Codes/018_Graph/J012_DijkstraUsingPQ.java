import java.util.*;

public class J012_DijkstraUsingPQ {

    // Pair class for adjacency list and Priority Queue
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] dijkstra(int V, List<List<Pair>> adj, int src) {

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Min Heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        // Source distance is 0
        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int dis = curr.dist;

            // Optimization:
            // Skip if this is an outdated entry
            if (dis > dist[node]) continue;

            // Traverse all adjacent nodes
            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int edgeWt = it.dist;

                // Relax the edge
                if (dis + edgeWt < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWt;

                    // Push updated distance into the Priority Queue
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        // Adjacency List
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph (Directed)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));

        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));

        adj.get(2).add(new Pair(4, 3));

        adj.get(3).add(new Pair(4, 1));

        int[] ans = dijkstra(V, adj, 0);

        System.out.println("Shortest Distance from Source:");

        for (int i = 0; i < V; i++) {
            System.out.println("0 -> " + i + " = " + ans[i]);
        }
    }
}