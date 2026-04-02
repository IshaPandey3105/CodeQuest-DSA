import java.util.PriorityQueue;

public class J03_KSortedArray {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 4, 6 };
        int k = 2;
        int[] sortedArr = sortKSortedArray(arr, k);
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortKSortedArray(int[] arr, int k) {
        // Implementation for sorting k-sorted array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;
        for(int i : arr){
            minHeap.add(i);
            if(minHeap.size() > k){
                arr[j]=minHeap.remove();
                j++;
            }
        }
        while (!minHeap.isEmpty()) {
            arr[j] = minHeap.remove();
            j++;
        }
        return arr;
    }

}
