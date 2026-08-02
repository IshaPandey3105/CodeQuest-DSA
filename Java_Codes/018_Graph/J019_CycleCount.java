public class J019_CycleCount {

    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        // Cycle Found
        if (pu == pv)
            return false;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 7;

        // Undirected Graph
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0}, // Cycle 1

                {2, 3},
                {3, 4},
                {4, 5},
                {5, 3}, // Cycle 2

                {5, 6}
        };

        parent = new int[V];
        size = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int cycles = 0;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                cycles++;
            }
        }

        System.out.println("Total Cycles = " + cycles);
    }
}