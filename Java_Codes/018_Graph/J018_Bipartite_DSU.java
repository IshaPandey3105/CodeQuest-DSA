// 1. Every neighbour of a node must belong to the opposite partition.
// 2. So, all neighbours of the same node are unioned into one DSU set.
// 3. Before unioning, check if the current node and its neighbour already belong to the same set.
// 4. If yes → graph is not bipartite.
// 5. If traversal finishes without conflict → graph is bipartite.
// TC :::: O(V + E · α(V)) ≈ O(V + E)
import java.util.*;

public class J018_Bipartite_DSU {

    static class DSU {

        int[] parent;
        int[] rank;
        boolean[] parity;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            parity = new boolean[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                parity[i] = false;
            }
        }

        // Finds parent and updates parity to the ultimate parent
        int find(int node) {

            if (parent[node] == node)
                return node;

            int originalParent = parent[node];

            parent[node] = find(parent[node]);

            parity[node] ^= parity[originalParent]; // XOR operator

            return parent[node];
        }

        // Connect u and v such that they are in opposite colors
        boolean union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            boolean parityU = parity[u];
            boolean parityV = parity[v];

            // Already in same component
            if (pu == pv) {

                // Same color -> conflict
                if (parityU == parityV)
                    return false;

                return true;
            }

            // Union by Rank
            if (rank[pu] < rank[pv]) {

                parent[pu] = pv;
                parity[pu] = !(parityU ^ parityV);

            } else if (rank[pv] < rank[pu]) {

                parent[pv] = pu;
                parity[pv] = !(parityU ^ parityV);

            } else {

                parent[pv] = pu;
                parity[pv] = !(parityU ^ parityV);
                rank[pu]++;
            }

            return true;
        }
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

        DSU dsu = new DSU(V);

        for (int u = 0; u < V; u++) {

            for (int v : adj.get(u)) {

                if (!dsu.union(u, v))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // 0-1-2-3-0

        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(0);
        adj.get(3).add(2);

        System.out.println(isBipartite(V, adj)); // true
    }
}