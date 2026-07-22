import java.util.ArrayList;
import java.util.Collections;

class DisjointSet {

    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]); // Path Compression
    }

    void unionBySize(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {

            parent[pu] = pv;
            size[pv] += size[pu];

        } else {

            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Edge implements Comparable<Edge> {

    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

public class J017_KruskalAlgo {

    public static int kruskalMST(int V, ArrayList<Edge> edges) {

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;

        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;
            int wt = edge.wt;

            if (ds.findParent(u) != ds.findParent(v)) {

                mstWeight += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        int mst = kruskalMST(V, edges);

        System.out.println("Minimum Spanning Tree Weight = " + mst);
    }
}