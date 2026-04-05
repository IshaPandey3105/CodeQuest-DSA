// Min Heap Implementation in Java
class MinHeap{
    private int arr[];
    private int size;
    MinHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
    }
    public void add(int data)  throws RuntimeException {
        if(size == arr.length) {
            throw new RuntimeException("Heap is full");
        }
        arr[size++] = data;
        upHeapify(size-1);
    }
    private void upHeapify(int idx) {
        if(idx == 0) return; // Reached root base case
        int parent = (idx-1)/2;
        if( parent >=0 && arr[parent]>arr[idx]) {
            swap(parent, idx);
            upHeapify(parent);
        }
    }
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
    public int peek() throws Exception {
        if(size == 0){
            throw new Exception("Heap is empty");
        }  
        return arr[0];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void display() {
        for(int i=0;i<size;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int remove() {
        if(size == 0) return -1; // or throw exception
        int min = arr[0];
        arr[0] = arr[size-1];
        size--;
        downHeapify(0);
        return min;
    }
    private void downHeapify(int idx) {
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int smallest = idx;

        if(left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if(right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if(smallest != idx) {
            swap(smallest, idx);
            downHeapify(smallest);
        }
    }
}

// Max Heap Implementation in Java
class MaxHeap{
    private int arr[];
    private int size;
    MaxHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
    }
    public void add(int data)  throws RuntimeException {
        if(size == arr.length) {
            throw new RuntimeException("Heap is full");
        }
        arr[size++] = data;
        upHeapify(size-1);
    }
    private void upHeapify(int idx) {
        if(idx == 0) return; // Reached root base case
        int parent = (idx-1)/2;
        if( parent >=0 && arr[parent]<arr[idx]) {
            swap(parent, idx);
            upHeapify(parent);
        }
    }
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }
    public int peek() throws Exception {
        if(size == 0){
            throw new Exception("Heap is empty");
        }  
        return arr[0];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void display() {
        for(int i=0;i<size;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int remove() throws Exception {
        if(size == 0)  throw new Exception("Heap is empty"); 
        int min = arr[0];
        arr[0] = arr[size-1];
        size--;
        downHeapify(0);
        return min;
    }
    private void downHeapify(int idx) {
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int largest = idx;

        if(left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != idx) {
            swap(largest, idx);
            downHeapify(largest);
        }
    }

}

public class J08_HeapImplimentation {
    public static void main(String[] args) throws Exception {
        MinHeap minheap = new MinHeap(5);
        // System.out.println(minheap.peek()); // Should throw exception as heap is empty
        minheap.add(10);
        minheap.add(20);
        minheap.add(5);
        minheap.add(15);
        minheap.add(25);

        minheap.display();
        System.out.println("Peek elem: "+ minheap.peek()); // Should print 5
        System.out.println("Removed elem: "+minheap.remove()); // Should remove and print 5
        System.out.println("Peek elem: "+minheap.peek()); // Should print 10

        System.out.println("-------------");
        MaxHeap maxheap = new MaxHeap(5);
        maxheap.add(10);
        maxheap.add(20);
        maxheap.add(5);
        maxheap.add(15);
        maxheap.add(25);
        maxheap.display();
        System.out.println("Peek elem: "+ maxheap.peek()); // Should print 25
        System.out.println("Removed elem: "+maxheap.remove()); // Should remove and print 25
        System.out.println("Peek elem: "+maxheap.peek()); // Should print 20

        // Heap Sort using Min Heap
        int[] arr = {10, 20, 5, 15, 25};
        MinHeap heap = new MinHeap(arr.length);
        for(int num : arr) {
            heap.add(num);
        }
        System.out.println("Heap Sort using Min Heap:");
        // Removing all elements from heap will and make array in sorted order
        int[] ans = new int[arr.length];
        int i=0;
        while(!heap.isEmpty()) {
            ans[i++]=heap.remove();
        }
        System.out.println("Sorted array: ");
        for(int num : ans) {
            System.out.print(num + " ");
        }
    }
}
