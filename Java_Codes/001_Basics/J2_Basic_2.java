/*
 * Java is a high-level, object-oriented language developed by Sun Microsystems (now Oracle).
 * Execution flow: Source code (.java) → Compiler (javac) → Bytecode (.class) → JVM (Interpreter/Just-In-Time compiler) → Output.
 * The compiler checks syntax/compile-time errors and converts code into bytecode.
 * The JVM interprets bytecode line by line and also uses JIT (Just-In-Time) compilation for efficiency.
 * A package in Java is a way to organize classes/interfaces (like folders); e.g., java.util, java.io, etc.
 */


public class J2_Basic_2 {
    public static void main(String[] args) {
        // finding the no. of digits and thier sum
        int n = 12345;
        int count=0;
        int sum=0;
        while(n!=0){
            sum=sum+(n%10);
            n/=10;
            count++;
        }
        System.out.println("No. of digits in the number is: "+count);
        System.out.println("Sum of digits in the number is: "+sum);
        System.out.println(Math.pow(5, 4));

    }
}
