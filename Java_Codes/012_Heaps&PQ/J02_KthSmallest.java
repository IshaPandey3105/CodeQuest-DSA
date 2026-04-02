import java.util.*;

public class J02_KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20,5, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
        System.out.println(kthSmallest1(arr, k));
    }
    // M1: Using Selection Sort till Kth element
    // M2: Using Built-in Sort and return K-1 th element
    // M3: Using Min Heap and pop K-1 times and return top element

    public static int kthSmallest(int[] arr, int k) {
        // Implementation for finding kth smallest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : arr) {
            minHeap.add(num);
        }
        for(int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }
        // System.out.println(minHeap);
        return minHeap.peek();
    }
    // M4: Using Max Heap and maintain size of heap as K, if size exceeds K then remove top element 
    public static int kthSmallest1(int[] arr, int k) {
        // Implementation for finding kth smallest element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++) {
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        System.out.println(maxHeap);
        return maxHeap.peek();
    }
}
