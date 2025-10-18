import java.util.Scanner;

// Generate all valid parenthesis 
public class J11_GenerateParenthesis {

    public static void GP(int open,int close,int n,String ans){
        if(ans.length()==2*n){
            System.out.println(ans);
            return;
        }
        if(open<n) GP(open+1,close,n,ans+'(');
        if(close<open) GP(open,close+1,n,ans+')');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n:");
        int n= sc.nextInt();
        GP(0,0,n,"");
        sc.close();
    }
}
