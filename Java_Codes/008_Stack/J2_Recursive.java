import java.util.Stack;

public class J2_Recursive {
    public static void recursive(Stack<Integer> st){
        // System.out.println(" Original order : "+st);
        if(st.empty()) return;
        int top=st.pop();
        System.out.print(top+" ");
        recursive(st);
        st.push(top);
    }
    public static void main(String[] args) {
        // recursive method of printing reverse order without using new stack
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println("Original order : "+st );
        System.out.print("Reversed order : " );
        recursive(st);
        System.out.println("\nOriginal order : "+st);
    }
}
