// ================================================================
//                    GRAPH ALGORITHMS REVISION
// ================================================================
// File: GraphAlgorithmsRevision.java
// Purpose: Quick revision of important Graph algorithms
//
// Topics:
// 1. BFS
// 2. DFS
// 3. Undirected Cycle Detection - BFS
// 4. Undirected Cycle Detection - DFS
// 5. Directed Cycle Detection - DFS
// 6. Directed Cycle Detection - BFS (Kahn's Algorithm)
// 7. Topological Sort - BFS (Kahn's Algorithm)
// 8. Topological Sort - DFS
// 9. Number of Islands
// 10. Bipartite Graph - BFS
// 11. Bipartite Graph - DFS
// 12. Kosaraju's Algorithm
// 13. Dijkstra's Algorithm
// 14. Bellman-Ford Algorithm
// 15. Floyd-Warshall Algorithm
// 16. Prim's MST
// 17. Kruskal's MST
// ================================================================


// ================================================================
// 1. BFS
// ================================================================

// public void bfs(int start, List<List<Integer>> adj) {
//     boolean[] visited = new boolean[adj.size()];
//     Queue<Integer> queue = new LinkedList<>();
//
//     queue.add(start);
//     visited[start] = true;
//
//     while (!queue.isEmpty()) {
//         int currentNode = queue.remove();
//
//         for (int neighbor : adj.get(currentNode)) {
//             if (!visited[neighbor]) {
//                 visited[neighbor] = true;
//                 queue.add(neighbor);
//             }
//         }
//     }
// }


// ================================================================
// 2. DFS
// ================================================================

// public void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
//     visited[node] = true;
//
//     for (int neighbor : adj.get(node)) {
//         if (!visited[neighbor]) {
//             dfs(neighbor, adj, visited);
//         }
//     }
// }


// ================================================================
// 3. Detect Cycle in Undirected Graph - BFS
// ================================================================

// class Pair {
//     int node;
//     int parent;
//
//     Pair(int node, int parent) {
//         this.node = node;
//         this.parent = parent;
//     }
// }
//
// public boolean hasCycleBFS(int start, List<List<Integer>> adj,
//                            boolean[] visited) {
//
//     Queue<Pair> queue = new LinkedList<>();
//
//     queue.add(new Pair(start, -1));
//     visited[start] = true;
//
//     while (!queue.isEmpty()) {
//         Pair current = queue.remove();
//
//         int currentNode = current.node;
//         int parent = current.parent;
//
//         for (int neighbor : adj.get(currentNode)) {
//
//             if (!visited[neighbor]) {
//                 visited[neighbor] = true;
//                 queue.add(new Pair(neighbor, currentNode));
//             }
//
//             else if (neighbor != parent) {
//                 return true;
//             }
//         }
//     }
//
//     return false;
// }


// ================================================================
// 4. Detect Cycle in Undirected Graph - DFS
// ================================================================

// public boolean hasCycleDFS(int node, int parent,
//                            List<List<Integer>> adj,
//                            boolean[] visited) {
//
//     visited[node] = true;
//
//     for (int neighbor : adj.get(node)) {
//
//         if (!visited[neighbor]) {
//
//             if (hasCycleDFS(neighbor, node, adj, visited)) {
//                 return true;
//             }
//         }
//
//         else if (neighbor != parent) {
//             return true;
//         }
//     }
//
//     return false;
// }


// ================================================================
// 5. Detect Cycle in Directed Graph - DFS
// ================================================================

// public boolean hasDirectedCycleDFS(int node,
//                                    List<List<Integer>> adj,
//                                    boolean[] visited,
//                                    boolean[] path) {
//
//     visited[node] = true;
//     path[node] = true;
//
//     for (int neighbor : adj.get(node)) {
//
//         if (!visited[neighbor]) {
//
//             if (hasDirectedCycleDFS(neighbor, adj, visited, path)) {
//                 return true;
//             }
//         }
//
//         else if (path[neighbor]) {
//             return true;
//         }
//     }
//
//     path[node] = false;
//     return false;
// }


// ================================================================
// 6. Detect Cycle in Directed Graph - BFS
//    Kahn's Algorithm
// ================================================================

// public boolean hasDirectedCycleBFS(int vertices,
//                                    List<List<Integer>> adj) {
//
//     int[] indegree = new int[vertices];
//
//     // Calculate indegree
//     for (int node = 0; node < vertices; node++) {
//         for (int neighbor : adj.get(node)) {
//             indegree[neighbor]++;
//         }
//     }
//
//     Queue<Integer> queue = new LinkedList<>();
//
//     // Add all nodes having indegree 0
//     for (int node = 0; node < vertices; node++) {
//         if (indegree[node] == 0) {
//             queue.add(node);
//         }
//     }
//
//     int processedNodes = 0;
//
//     while (!queue.isEmpty()) {
//
//         int currentNode = queue.remove();
//         processedNodes++;
//
//         for (int neighbor : adj.get(currentNode)) {
//
//             indegree[neighbor]--;
//
//             if (indegree[neighbor] == 0) {
//                 queue.add(neighbor);
//             }
//         }
//     }
//
//     return processedNodes != vertices;
// }


// ================================================================
// 7. Topological Sort - BFS
//    Kahn's Algorithm
// ================================================================

// public List<Integer> topoSortBFS(int vertices,
//                                  List<List<Integer>> adj) {
//
//     int[] indegree = new int[vertices];
//
//     for (int node = 0; node < vertices; node++) {
//         for (int neighbor : adj.get(node)) {
//             indegree[neighbor]++;
//         }
//     }
//
//     Queue<Integer> queue = new LinkedList<>();
//
//     for (int node = 0; node < vertices; node++) {
//         if (indegree[node] == 0) {
//             queue.add(node);
//         }
//     }
//
//     List<Integer> topologicalOrder = new ArrayList<>();
//
//     while (!queue.isEmpty()) {
//
//         int currentNode = queue.remove();
//         topologicalOrder.add(currentNode);
//
//         for (int neighbor : adj.get(currentNode)) {
//
//             indegree[neighbor]--;
//
//             if (indegree[neighbor] == 0) {
//                 queue.add(neighbor);
//             }
//         }
//     }
//
//     return topologicalOrder;
// }


// ================================================================
// 8. Topological Sort - DFS
// ================================================================

// public void topoSortDFS(int node,
//                         List<List<Integer>> adj,
//                         boolean[] visited,
//                         Stack<Integer> stack) {
//
//     visited[node] = true;
//
//     for (int neighbor : adj.get(node)) {
//
//         if (!visited[neighbor]) {
//             topoSortDFS(neighbor, adj, visited, stack);
//         }
//     }
//
//     // Postorder
//     stack.push(node);
// }
//
// public List<Integer> topoSortDFS(List<List<Integer>> adj) {
//
//     int vertices = adj.size();
//     boolean[] visited = new boolean[vertices];
//     Stack<Integer> stack = new Stack<>();
//
//     for (int node = 0; node < vertices; node++) {
//
//         if (!visited[node]) {
//             topoSortDFS(node, adj, visited, stack);
//         }
//     }
//
//     List<Integer> result = new ArrayList<>();
//
//     while (!stack.isEmpty()) {
//         result.add(stack.pop());
//     }
//
//     return result;
// }


// ================================================================
// 9. Number of Islands - BFS
// ================================================================

// class GridPair {
//     int row;
//     int col;
//
//     GridPair(int row, int col) {
//         this.row = row;
//         this.col = col;
//     }
// }
//
// public void bfs(int row, int col,
//                 char[][] grid,
//                 boolean[][] visited) {
//
//     int rows = grid.length;
//     int cols = grid[0].length;
//
//     Queue<GridPair> queue = new LinkedList<>();
//
//     queue.add(new GridPair(row, col));
//     visited[row][col] = true;
//
//     int[] dRow = {-1, 0, 1, 0};
//     int[] dCol = {0, -1, 0, 1};
//
//     while (!queue.isEmpty()) {
//
//         GridPair current = queue.remove();
//
//         for (int i = 0; i < 4; i++) {
//
//             int newRow = current.row + dRow[i];
//             int newCol = current.col + dCol[i];
//
//             if (newRow < 0 || newCol < 0 ||
//                 newRow >= rows || newCol >= cols) {
//                 continue;
//             }
//
//             if (grid[newRow][newCol] == '1' &&
//                 !visited[newRow][newCol]) {
//
//                 visited[newRow][newCol] = true;
//                 queue.add(new GridPair(newRow, newCol));
//             }
//         }
//     }
// }
//
// public int numIslands(char[][] grid) {
//
//     int rows = grid.length;
//     int cols = grid[0].length;
//
//     boolean[][] visited = new boolean[rows][cols];
//     int islandCount = 0;
//
//     for (int row = 0; row < rows; row++) {
//
//         for (int col = 0; col < cols; col++) {
//
//             if (grid[row][col] == '1' &&
//                 !visited[row][col]) {
//
//                 bfs(row, col, grid, visited);
//                 islandCount++;
//             }
//         }
//     }
//
//     return islandCount;
// }


// ================================================================
// 10. Bipartite Graph - BFS
// ================================================================

// public boolean isBipartiteBFS(List<List<Integer>> adj) {
//
//     int vertices = adj.size();
//
//     // -1 = uncolored
//     //  0 / 1 = colors
//     int[] color = new int[vertices];
//     Arrays.fill(color, -1);
//
//     Queue<Integer> queue = new LinkedList<>();
//
//     for (int start = 0; start < vertices; start++) {
//
//         if (color[start] != -1) {
//             continue;
//         }
//
//         color[start] = 0;
//         queue.add(start);
//
//         while (!queue.isEmpty()) {
//
//             int currentNode = queue.remove();
//
//             for (int neighbor : adj.get(currentNode)) {
//
//                 if (color[neighbor] == -1) {
//
//                     color[neighbor] = 1 - color[currentNode];
//                     queue.add(neighbor);
//                 }
//
//                 else if (color[neighbor] == color[currentNode]) {
//                     return false;
//                 }
//             }
//         }
//     }
//
//     return true;
// }


// ================================================================
// 11. Bipartite Graph - DFS
// ================================================================

// public boolean isBipartiteDFS(int node,
//                               List<List<Integer>> adj,
//                               int[] color) {
//
//     for (int neighbor : adj.get(node)) {
//
//         if (color[neighbor] == -1) {
//
//             color[neighbor] = 1 - color[node];
//
//             if (!isBipartiteDFS(neighbor, adj, color)) {
//                 return false;
//             }
//         }
//
//         else if (color[neighbor] == color[node]) {
//             return false;
//         }
//     }
//
//     return true;
// }
//
// public boolean isBipartite(List<List<Integer>> adj) {
//
//     int vertices = adj.size();
//
//     int[] color = new int[vertices];
//     Arrays.fill(color, -1);
//
//     for (int node = 0; node < vertices; node++) {
//
//         if (color[node] == -1) {
//
//             color[node] = 0;
//
//             if (!isBipartiteDFS(node, adj, color)) {
//                 return false;
//             }
//         }
//     }
//
//     return true;
// }


// ================================================================
// 12. Kosaraju's Algorithm - SCC
// ================================================================

// // Step 1: DFS and store nodes according to finishing time
// public void kosarajuDFS1(int node,
//                          List<List<Integer>> adj,
//                          boolean[] visited,
//                          Stack<Integer> stack) {
//
//     visited[node] = true;
//
//     for (int neighbor : adj.get(node)) {
//
//         if (!visited[neighbor]) {
//             kosarajuDFS1(neighbor, adj, visited, stack);
//         }
//     }
//
//     stack.push(node);
// }
//
//
// // Step 2: Reverse the graph
// public List<List<Integer>> reverseGraph(List<List<Integer>> adj) {
//
//     int vertices = adj.size();
//     List<List<Integer>> reversed = new ArrayList<>();
//
//     for (int i = 0; i < vertices; i++) {
//         reversed.add(new ArrayList<>());
//     }
//
//     for (int node = 0; node < vertices; node++) {
//
//         for (int neighbor : adj.get(node)) {
//             reversed.get(neighbor).add(node);
//         }
//     }
//
//     return reversed;
// }
//
//
// // Step 3: DFS on reversed graph according to stack order
// public void kosarajuDFS2(int node,
//                          List<List<Integer>> reversed,
//                          boolean[] visited) {
//
//     visited[node] = true;
//
//     for (int neighbor : reversed.get(node)) {
//
//         if (!visited[neighbor]) {
//             kosarajuDFS2(neighbor, reversed, visited);
//         }
//     }
// }
//
//
// public int kosaraju(List<List<Integer>> adj) {
//
//     int vertices = adj.size();
//
//     boolean[] visited = new boolean[vertices];
//     Stack<Integer> stack = new Stack<>();
//
//     // Step 1
//     for (int node = 0; node < vertices; node++) {
//
//         if (!visited[node]) {
//             kosarajuDFS1(node, adj, visited, stack);
//         }
//     }
//
//     // Step 2
//     List<List<Integer>> reversed = reverseGraph(adj);
//
//     // Step 3
//     Arrays.fill(visited, false);
//
//     int sccCount = 0;
//
//     while (!stack.isEmpty()) {
//
//         int node = stack.pop();
//
//         if (!visited[node]) {
//
//             kosarajuDFS2(node, reversed, visited);
//             sccCount++;
//         }
//     }
//
//     return sccCount;
// }


// ================================================================
// 13. Dijkstra's Algorithm
// ================================================================

// class WeightedPair {
//     int node;
//     int distance;
//
//     WeightedPair(int node, int distance) {
//         this.node = node;
//         this.distance = distance;
//     }
// }
//
// public int[] dijkstra(int source,
//                       List<List<WeightedPair>> adj) {
//
//     int vertices = adj.size();
//
//     int[] dist = new int[vertices];
//     Arrays.fill(dist, Integer.MAX_VALUE);
//
//     PriorityQueue<WeightedPair> pq =
//         new PriorityQueue<>((a, b) -> a.distance - b.distance);
//
//     dist[source] = 0;
//     pq.add(new WeightedPair(source, 0));
//
//     while (!pq.isEmpty()) {
//
//         WeightedPair current = pq.remove();
//
//         int currentNode = current.node;
//         int currentDistance = current.distance;
//
//         // Ignore stale entry
//         if (currentDistance > dist[currentNode]) {
//             continue;
//         }
//
//         for (WeightedPair neighbor : adj.get(currentNode)) {
//
//             int neighborNode = neighbor.node;
//             int edgeWeight = neighbor.distance;
//
//             if (currentDistance + edgeWeight < dist[neighborNode]) {
//
//                 dist[neighborNode] =
//                     currentDistance + edgeWeight;
//
//                 pq.add(new WeightedPair(
//                     neighborNode,
//                     dist[neighborNode]
//                 ));
//             }
//         }
//     }
//
//     return dist;
// }


// ================================================================
// 14. Bellman-Ford Algorithm
// ================================================================

// class Edge {
//     int source;
//     int destination;
//     int weight;
//
//     Edge(int source, int destination, int weight) {
//         this.source = source;
//         this.destination = destination;
//         this.weight = weight;
//     }
// }
//
// public int[] bellmanFord(int vertices,
//                          int source,
//                          List<Edge> edges) {
//
//     int[] dist = new int[vertices];
//     Arrays.fill(dist, Integer.MAX_VALUE);
//
//     dist[source] = 0;
//
//     // Relax all edges V - 1 times
//     for (int i = 1; i <= vertices - 1; i++) {
//
//         boolean updated = false;
//
//         for (Edge edge : edges) {
//
//             if (dist[edge.source] == Integer.MAX_VALUE) {
//                 continue;
//             }
//
//             if (dist[edge.source] + edge.weight <
//                 dist[edge.destination]) {
//
//                 dist[edge.destination] =
//                     dist[edge.source] + edge.weight;
//
//                 updated = true;
//             }
//         }
//
//         // Optional optimization
//         if (!updated) {
//             break;
//         }
//     }
//
//     // One extra pass to detect negative cycle
//     for (Edge edge : edges) {
//
//         if (dist[edge.source] == Integer.MAX_VALUE) {
//             continue;
//         }
//
//         if (dist[edge.source] + edge.weight <
//             dist[edge.destination]) {
//
//             // Negative cycle exists
//             System.out.println("Negative cycle detected");
//             return null;
//         }
//     }
//
//     return dist;
// }


// ================================================================
// 15. Floyd-Warshall Algorithm
// ================================================================

// public void floydWarshall(int[][] dist) {
//
//     int vertices = dist.length;
//     int INF = Integer.MAX_VALUE;
//
//     for (int k = 0; k < vertices; k++) {
//
//         for (int i = 0; i < vertices; i++) {
//
//             if (dist[i][k] == INF) {
//                 continue;
//             }
//
//             for (int j = 0; j < vertices; j++) {
//
//                 if (dist[k][j] == INF) {
//                     continue;
//                 }
//
//                 dist[i][j] = Math.min(
//                     dist[i][j],
//                     dist[i][k] + dist[k][j]
//                 );
//             }
//         }
//     }
//
//     // Negative cycle detection
//     for (int i = 0; i < vertices; i++) {
//
//         if (dist[i][i] < 0) {
//             System.out.println("Negative cycle detected");
//         }
//     }
// }


// ================================================================
// 16. Prim's MST
// ================================================================

// class PrimTriplet {
//     int node;
//     int parent;
//     int weight;
//
//     PrimTriplet(int node, int parent, int weight) {
//         this.node = node;
//         this.parent = parent;
//         this.weight = weight;
//     }
// }
//
// public int primMST(int vertices,
//                    List<List<PrimTriplet>> adj) {
//
//     boolean[] visited = new boolean[vertices];
//
//     PriorityQueue<PrimTriplet> pq =
//         new PriorityQueue<>((a, b) -> a.weight - b.weight);
//
//     // node, parent, edgeWeight
//     pq.add(new PrimTriplet(0, -1, 0));
//
//     int mstCost = 0;
//     int mstEdges = 0;
//
//     while (!pq.isEmpty()) {
//
//         PrimTriplet current = pq.remove();
//
//         int currentNode = current.node;
//         int parent = current.parent;
//         int edgeWeight = current.weight;
//
//         if (visited[currentNode]) {
//             continue;
//         }
//
//         visited[currentNode] = true;
//
//         if (parent != -1) {
//             mstCost += edgeWeight;
//             mstEdges++;
//         }
//
//         for (PrimTriplet neighbor : adj.get(currentNode)) {
//
//             if (!visited[neighbor.node]) {
//
//                 pq.add(new PrimTriplet(
//                     neighbor.node,
//                     currentNode,
//                     neighbor.weight
//                 ));
//             }
//         }
//     }
//
//     return mstCost;
// }


// ================================================================
// 17. Kruskal's MST
// ================================================================

// class DSU {
//
//     int[] parent;
//     int[] size;
//
//     DSU(int vertices) {
//
//         parent = new int[vertices];
//         size = new int[vertices];
//
//         for (int i = 0; i < vertices; i++) {
//             parent[i] = i;
//             size[i] = 1;
//         }
//     }
//
//     int find(int node) {
//
//         if (parent[node] == node) {
//             return node;
//         }
//
//         return parent[node] = find(parent[node]);
//     }
//
//     void union(int u, int v) {
//
//         int parentU = find(u);
//         int parentV = find(v);
//
//         if (parentU == parentV) {
//             return;
//         }
//
//         if (size[parentU] < size[parentV]) {
//             parent[parentU] = parentV;
//             size[parentV] += size[parentU];
//         }
//
//         else {
//             parent[parentV] = parentU;
//             size[parentU] += size[parentV];
//         }
//     }
// }
//
// public int kruskalMST(int vertices, List<Edge> edges) {
//
//     edges.sort((a, b) -> a.weight - b.weight);
//
//     DSU dsu = new DSU(vertices);
//
//     int mstCost = 0;
//     int mstEdges = 0;
//
//     for (Edge edge : edges) {
//
//         int parentU = dsu.find(edge.source);
//         int parentV = dsu.find(edge.destination);
//
//         if (parentU != parentV) {
//
//             mstCost += edge.weight;
//             mstEdges++;
//
//             dsu.union(parentU, parentV);
//
//             if (mstEdges == vertices - 1) {
//                 break;
//             }
//         }
//     }
//
//     return mstCost;
// }


// ================================================================
//                    END OF GRAPH REVISION
// ================================================================
//
// Revision strategy:
// 1. First try to write each algorithm WITHOUT looking.
// 2. Then uncomment and compare.
// 3. Don't memorize syntax.
// 4. Remember the core pattern + data structure + complexity.
//
// ================================================================