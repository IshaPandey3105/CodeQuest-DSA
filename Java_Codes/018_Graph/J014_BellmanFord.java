import java.util.*;

class Edge {
    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

public class J014_BellmanFord {

    static int[] bellmanFord(int V, ArrayList<Edge> edges, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            boolean updated = false;

            for (Edge e : edges) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                    updated = true;
                }
            }

            // Optimization: stop if no relaxation happened
            if (!updated)
                break;
        }

        // Negative Cycle Detection
        for (Edge e : edges) {

            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                System.out.println("Negative Weight Cycle Detected!");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 3, 7));
        edges.add(new Edge(4, 0, 2));

        int src = 0;

        int[] ans = bellmanFord(V, edges, src);

        if (ans != null) {
            System.out.println("Shortest Distance from Source " + src);

            for (int i = 0; i < V; i++) {
                System.out.println(src + " -> " + i + " = " + ans[i]);
            }
        }
    }
}