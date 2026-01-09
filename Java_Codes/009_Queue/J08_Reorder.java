import java.util.*;
import java.util.Stack;

public class J08_Reorder {
    public static void main(String[] args) {
        // reordering of array
        int[] arr = {1,2,3,4,5,6,7,8};
        int n= arr.length;
        int[] res = new int[n];
        int k=0;
        for(int i=0;i<n/2;i++){
            res[k++] = arr[i];
            res[k++] = arr[i+n/2];
        }
        System.out.println(Arrays.toString(res));

        // interleaving first half with second half of queue
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        // using array
        for(k=0;k<8;k=k+2){
            res[k] = q.remove();
        }
        for(k=1;k<8;k=k+2){
            res[k] = q.remove();
        }
        System.out.println("q:"+ Arrays.toString(res));

        // using stack
        
        q.add(1); // as queue become empty soo adding elem
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println("queue:"+ q);
        Stack<Integer> st = new Stack<>();
        int i=0;
        n=q.size();
        // step1 : moving 1st half of queue to stack
        while(i<n/2){
            st.push(q.remove());
            i++;
        }
        System.out.println("1"+ q);
        // step2 : empty stack to queue
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        System.out.println("2"+ q);
        // step3 : moving 1st half of queue to stack again
        i=0;
        while(i<n/2){
            st.push(q.remove());
            i++;
        }
        System.out.println("3"+ q);
        // step4: adding elem one by one into queue
        while(!st.isEmpty()){
            q.add(st.pop());
            q.add(q.remove());
        }
        System.out.println("4"+ q);
        // step5 : reversing queue
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        System.out.println("ans"+ q);
    }
}
