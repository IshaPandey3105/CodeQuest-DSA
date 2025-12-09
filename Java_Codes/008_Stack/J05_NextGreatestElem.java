import java.util.Stack;
public class J05_NextGreatestElem {

    public static void Print(int[] arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={1,3,2,4};
        // int[] arr={2,4,3,5,1};
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        // int i=n-1;
        // while(i>=0){
        //     if(st.isEmpty()) {
        //         ans[i]=-1;
        //     }
        //     else if(st.peek()>arr[i]) {
        //         ans[i]=st.peek();
        //     }else{
        //         while(!st.isEmpty() && arr[i]>=st.peek()){
        //             st.pop();
        //         }
        //         if(st.isEmpty()) ans[i]=-1;
        //         else ans[i]=st.peek();
        //     }
        //     i--;
        //     st.push(arr[i]);
        // }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                    st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        Print(arr);
        Print(ans);
    }
}
