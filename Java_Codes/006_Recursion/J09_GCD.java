import java.util.Scanner;

public class J09_GCD {

    public static int HCF(int a , int b){
        if(b%a==0) return a;
        return HCF(b%a,a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a and b :");
        int a= sc.nextInt();
        int b= sc.nextInt();
        int n=HCF(a,b);
        System.out.println(n);
        sc.close();
    }
}
