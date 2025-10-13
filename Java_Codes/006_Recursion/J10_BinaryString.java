// Priting binary string of length n with no consecutive 1's

import java.util.Scanner;

public class J10_BinaryString {

    public static void BS(String ans,int n){
        int m=ans.length();
        if(n==m) {
            System.out.println(ans);
            return;
        }
        if(m==0||ans.charAt(m-1)=='0'){
            BS(ans+"0",n);
            BS(ans+"1",n);
        }
        else{
            BS(ans+"0",n);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n:");
        int n= sc.nextInt();
        BS("",n);
        sc.close();
    }
}
