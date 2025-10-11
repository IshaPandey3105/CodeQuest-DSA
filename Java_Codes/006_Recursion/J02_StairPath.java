import java.util.Scanner;

public class J02_StairPath {
    public static int stairPath(int n){  // TC=O(2ⁿ)
        if(n<=2) return n;
        return stairPath(n-1)+stairPath(n-2);
    }
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int ans=stairPath(n);
        System.out.println(ans);
        sc.close();
    }
}
