import java.util.*;

public class J010_AlienDictionary {

    public static void main(String[] args) {

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        // Mark all characters that appear
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid case
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    // Avoid duplicate edges
                    if (!adj.get(c1 - 'a').contains(c2 - 'a')) {
                        adj.get(c1 - 'a').add(c2 - 'a');
                        indegree[c2 - 'a']++;
                    }

                    break;
                }
            }
        }

        // Kahn's Algorithm (Topological Sort)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.poll();
            ans.append((char) (node + 'a'));

            for (int neigh : adj.get(node)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        // Count total unique characters
        int totalChars = 0;
        for (boolean b : present) {
            if (b) totalChars++;
        }

        // Cycle exists
        if (ans.length() != totalChars) {
            return "";
        }

        return ans.toString();
    }
}