import java.util.Stack;
public class J1_Basic {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st);   // print the stack
        // System.out.println("1st pop elem :"+st.pop());
        // System.out.println("2nd pop elem :"+ st.pop());
        // System.out.println("top elem :"+st.peek());

        // reversal of stack   // tc: O(N) ans sc: O(N)
        Stack<Integer> st_new = new Stack<>();
        while(!st.empty()){
            // int elem=st.pop();
            // st_new.push(elem);
            st_new.push(st.pop());
        }
        System.out.println("Revers order : "+st_new);
    
        // equating 2 stacks 
        st=st_new;
        System.out.println(st);  

        // copying the stack elem into another stack in same order  // tc: O(2N) ans sc: O(2N)
        Stack <Integer> temp = new Stack<>();
        while(!st_new.empty()){
            temp.push(st_new.pop());
        }
        System.out.println("same order : "+ temp);
        
        // push elements to a particular index
        st=temp;
        Stack <Integer> st2 = new Stack<>();
        int pos=2;
        int elem = 100;
        while(st.size()>=pos){
            st2.push(st.pop());
        }
        st.push(elem);
        while(!st2.empty()){
            st.push(st2.pop()); 
        }
        System.out.println(st);
    }
}
