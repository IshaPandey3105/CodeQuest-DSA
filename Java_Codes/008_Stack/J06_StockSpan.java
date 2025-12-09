import java.util.Stack;
public class J06_StockSpan {
    public static void Print(int[] arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85,200};
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int n=arr.length;
        for(int i=0;i<n;i++){    // i=days
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=i+1;
            else ans[i]=i-st.peek();
            st.push(i);
        }
        Print(arr);
        Print(ans);
    }
}
