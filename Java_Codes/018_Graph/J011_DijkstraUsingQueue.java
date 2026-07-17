import java.util.*;

public class J011_DijkstraUsingQueue {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] shortestPath(int V, List<List<Pair>> adj, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        dist[src] = 0;
        q.offer(new Pair(src, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int node = curr.node;
            int dis = curr.dist;

            // Skip outdated entry
            if (dis > dist[node]) continue;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int edgeWt = it.dist;

                if (dis + edgeWt < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWt;
                    q.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));

        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));

        adj.get(2).add(new Pair(4, 3));

        adj.get(3).add(new Pair(4, 1));

        int[] ans = shortestPath(V, adj, 0);

        System.out.println("Shortest Distance from Source:");

        for (int i = 0; i < V; i++) {
            System.out.println("0 -> " + i + " = " + ans[i]);
        }
    }
}