import java.util.*;
import java.util.Stack;

public class J01_QueueBasics {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);

        que.offer(5);
        // que.poll();    // removes 1

        // que.remove();          // removes 2
        // System.out.println(que.peek()); // prints 3

        // priting of queues using extra que
        Queue<Integer> que1 = new LinkedList<>();
        while(!que.isEmpty()){
            int a=que.remove();
            System.out.print(a + " "); // use que.peek()
            que1.add(a);
        }
        while(!que1.isEmpty()){
            que.add(que1.remove());
        }
        System.out.println("\n" + que);  // [1, 2, 3, 4, 5]
        System.out.println(que1);

        // reversing elements of queues using stacks
        while(!que.isEmpty()){
            st.push(que.remove());
        }
        while(!st.isEmpty()){
            que.add(st.pop());
        }
        System.out.println(que);  // [5, 4, 3, 2, 1]

        // removing elements presnt in even indx (0 based indexing)
        while(!que.isEmpty()){
            que.remove();
            if(!que.isEmpty()) que1.add(que.remove());
        }
        que=que1;
        System.out.println("\n" + que);  // [4,2]
    }
}
