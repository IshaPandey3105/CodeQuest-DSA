import java.util.Scanner;

public class J03_MazePath {
    public static int mazePath(int m,int n){  // TC ≈ O(2^(m+n))
        if(m==1 || n==1) return 1;  // base case: only one path
        return mazePath(m,n-1)+mazePath(m-1,n); 
    }
    public static void main(String[] args) {
        System.out.print("Enter grid dimenstion : ");
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int ans=mazePath(m,n);
        System.out.println(ans);
        sc.close();
    }
}
