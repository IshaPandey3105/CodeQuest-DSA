class DisjointSet {

    int[] parent;
    int[] size;
    int[] rank;

    // Constructor
    DisjointSet(int n) {

        parent = new int[n + 1];
        size = new int[n + 1];
        rank = new int[n + 1];

        // Make Set -> O(N)
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    // -------------------------------------
    // FIND PARENT (WITHOUT PATH COMPRESSION)
    // TC: O(N) in Normal DSU
    // -------------------------------------
    int findParentNormal(int node) {

        if (parent[node] == node)
            return node;

        return findParentNormal(parent[node]);
    }

    // -------------------------------------
    // FIND PARENT (WITH PATH COMPRESSION)
    // TC: O(alpha(N))
    // -------------------------------------
    int findParent(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }

    // -------------------------------------
    // NORMAL UNION
    // Leader -> Leader
    // TC: O(N)
    // -------------------------------------
    void unionNormal(int u, int v) {

        int pu = findParentNormal(u);
        int pv = findParentNormal(v);

        if (pu == pv)
            return;

        parent[pv] = pu;
    }

    // -------------------------------------
    // UNION BY SIZE
    // TC: O(log N)
    // With Path Compression:
    // O(alpha(N))
    // -------------------------------------
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

    // -------------------------------------
    // UNION BY RANK
    // TC: O(log N)
    // With Path Compression:
    // O(alpha(N))
    // -------------------------------------
    void unionByRank(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;

        if (rank[pu] < rank[pv]) {

            parent[pu] = pv;

        } else if (rank[pv] < rank[pu]) {

            parent[pv] = pu;

        } else {

            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class J016_DisjointSetUnion {

    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);

        // Using Union By Size
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same Set");
        else
            System.out.println("Different Set");

        ds.unionBySize(3, 7);

        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same Set");
        else
            System.out.println("Different Set");
    }
}