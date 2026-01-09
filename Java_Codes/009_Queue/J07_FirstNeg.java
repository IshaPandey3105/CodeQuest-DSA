import java.util.*;

public class J07_FirstNeg {
    // first negative in each window of size k
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,6,28};
        int k=3;
        int n=8;
        // Brute Force
        int[] res = new int[n-k+1];
        for( int i=0;i<=n-k;i++){
            for(int j=i;j<=i+k-1;j++){
                if(arr[j]<0){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));

        // Optimized Tc = O(n) , SC = O(n)
        Queue<Integer> q = new LinkedList<>();
        int i=0;
        while(i<n){
            if(arr[i]<0){
                q.add(i);
            }
            i++;
        }
        for(i=0;i<=n-k;i++){
            if(q.size()!=0 && i>q.peek()){
                q.remove();
            }else if(q.peek()<i+k-1){
                res[i]=arr[q.peek()];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
