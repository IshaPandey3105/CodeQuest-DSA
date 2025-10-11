public class J05_ArraysTraversal {
    
    // public static void arrTrav(int[] arr,int n){
    //     if(n<0) return;
    //     arrTrav(arr,n-1);
    //     System.out.print(arr[n]);
    // }
    public static void arrTrav2(int[] arr,int n){
        if(n==arr.length) return;
        System.out.print(arr[n]+" ");
        arrTrav2(arr,n+1);
    }
    public static void stringTrav(String st,int n){
        if(n==st.length()) return;
        System.out.print(st.charAt(n));
        stringTrav(st,n+1);
    }

    public static void removingChar(String st,int n,String ans){
        if(n==st.length()){
            System.out.print(ans);
            return;
        }
        if(st.charAt(n) != 'a') ans += st.charAt(n);
        removingChar(st,n+1,ans);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        String st=" Isha Pandey ";
        arrTrav2(arr,0);
        stringTrav(st, 0);
        removingChar(st, 0,"");
    }
}
