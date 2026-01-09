import java.util.*;
import java.util.Stack;

// reversing first k elements from queues 

public class J06_ReverseK {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        System.out.println(que);
        int k=3;
        int n=que.size()-k;
        // Step 1: Remove first k elements and push to stack
        while(k>0){
            st.push(que.remove());
            k--;
        }
        System.out.println(que);
        // Step 2: Add stack elements back to queue
        while(!st.isEmpty()){
            que.add(st.pop());
        }
        System.out.println(que);
        // Step 3: Move remaining elements to back
        while(n>0){
            que.add(que.remove());
            n--;
        }
        System.out.println(que);
    }
}
