import java.util.PriorityQueue;

public class J07_MinCostRope{
    public static void main(String[] args) {
        int[] ropes = {2,7,4,8,1};
        System.out.println(minCost(ropes));
    }
    public static int minCost(int[] ropes) {
        // Implementation for finding minimum cost to connect all ropes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.add(rope);
        }
        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }
        return totalCost;
    }
}