public class J01_Basics {

    static int n=5;     // global variable

    // Printing numbers in inc and dec order
    public static void printing(int a){
        if (a == 0) return;                // base case to stop recursion
        System.out.println("No. is " + a); // print current number
        printing(a - 1);                   // recursive call with a-1
        System.out.println("No. is " + a);
    } 

    // Calculating Sum
    public static int sum(int n){
        if(n==0 || n==1) return n;
        return n+sum(n-1);
    }

    // Calculating Factorial
    public static int fac(int n){
        if(n<2) return 1;
        return n*fac(n-1);
    }

    // public static int power(int a,int b){   // TC=O(b)
    //     if(b==0) return 1;
    //     return a*power(a,b-1);
    // }

    // Calculating Fibonacci Number
    public static int fib(int n){
        if(n==0 || n==1) return n;
        return fib(n-1)+fib(n-2);
    }


    // Calculating Power
    public static int power(int a,int b){   // TC=O(log(b))
        if(b==0) return 1;
        int ans=power(a,b/2);
        if(b%2==0) return ans*ans;
        else return ans*ans*a;
    }

    public static void main(String[] args) {
        printing(n);
        System.out.println("Sum is: "+sum(n));
        System.out.println(fac(n));
        System.out.println("Power is: "+power(2,5));
        System.out.println("Fibonacci no. is: "+fib(4));
    }
}
