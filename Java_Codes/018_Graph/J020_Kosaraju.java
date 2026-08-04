import java.util.*;
import java.util.Stack;

public class J020_Kosaraju {

    // Step 1: DFS to store nodes according to finishing time
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis, Stack<Integer> st) {

        vis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, adj, vis, st);
            }
        }

        st.push(node);
    }

    // Step 3: DFS on reversed graph
    static void dfsReverse(int node, ArrayList<ArrayList<Integer>> revAdj,
                           boolean[] vis, List<Integer> component) {

        vis[node] = true;
        component.add(node);

        for (int nei : revAdj.get(node)) {
            if (!vis[nei]) {
                dfsReverse(nei, revAdj, vis, component);
            }
        }
    }

    static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        // ---------------- Step 1 ----------------
        // Store vertices in stack by finishing time
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }

        // ---------------- Step 2 ----------------
        // Reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int nei : adj.get(i)) {
                revAdj.get(nei).add(i);
            }
        }

        Arrays.fill(vis, false);

        // ---------------- Step 3 ----------------
        // Pop from stack and DFS on reversed graph
        int scc = 0;

        List<List<Integer>> sccList = new ArrayList<>();

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> component = new ArrayList<>();
                dfsReverse(node, revAdj, vis, component);
                sccList.add(component);
                scc++;
            }
        }
        for (int i = 0; i < sccList.size(); i++) {
        System.out.println("SCC " + (i + 1) + " : " + sccList.get(i));
}

        return scc;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);

        adj.get(0).add(3);
        adj.get(3).add(4);

        int count = kosaraju(V, adj);

        System.out.println("\nTotal SCC = " + count);
        

    }
}