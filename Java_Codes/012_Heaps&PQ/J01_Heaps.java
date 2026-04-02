// import java.util.Collections;
// import java.util.PriorityQueue;
import java.util.*;

public class J01_Heaps {
    public static void main(String[] args) {
        
        // min-heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        pq.add(2); 
        System.out.println(pq); 
        pq.add(10);
        System.out.println(pq); 
        pq.add(-1);
        System.out.println(pq); 
        pq.remove(); // removes the smallest element (-1)
        System.out.println(pq);
        System.out.println(pq.peek()); // prints 2, the new smallest element
        System.out.println(pq.isEmpty()); 
        System.out.println(pq.size()); // prints 2  

        // max-heap using reverse order comparator
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); 
        pq1.add(2); 
        System.out.println(pq1); 
        pq1.add(10);
        System.out.println(pq1); 
        pq1.add(-1);
        System.out.println(pq1); 
        pq1.remove(); // removes the smallest element (-1)
        System.out.println(pq1);
        System.out.println(pq1.peek()); // prints 2, the new smallest element
        System.out.println(pq1.isEmpty()); 
        System.out.println(pq1.size()); // prints 2  
    }
}
