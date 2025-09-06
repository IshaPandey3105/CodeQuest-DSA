import java.util.Scanner;
public class J1_Basic{
    public static void main(String[] args){
        // Takin Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a+b);

        System.out.println("Enter character and get ISCII value : ");
        char ch = sc.next().charAt(0);
        System.out.println(ch +" -> "+ (int)ch);
        
        // Basic printing of variables and text
        System.out.println();
        System.out.print("Hello World!\n");
        System.out.println("Hello World!");
        int x= 5;
        int y = 10;
        System.out.println((x*x));
        System.out.println("The value of x is: "+x);
        System.out.println("The value of sum is: "+(x+y));

        // Simple Interest
        double p =1000;
        double r =3.75;
        double t =10;
        double SI = (p*r*t)/100;
        System.out.println("The simple interest is: "+SI);
        
        // Properties of Modulus Operator
        // 1.a%b = a  if[a<b]
        // 2.a%(-b) = a%b
        // 3.(-a)%b = -a%b
        // 4.(-a)%(-b) = -a%b


        // double/int = double
        System.out.println(5.0/2);
        System.out.println(5/2.0);
        System.out.println(5.0/2.0);
        System.out.println(5/2);

        // in java comparison operator gives boolean value[true,false]
        System.out.println(true && false); // false

        // conditionals 
        // 1. if-else
        // 2. else if 
        // 3. switch
        // 4. ternary operator
        // 5. nested if-else
        // 6. multiple conditions - &&,||

        // Take integer input and print its absolute value
        System.out.println( " Enter a integer: ");
        int num=sc.nextInt();
        if(num<0){
            System.out.println("Absolute Value : "+ (-num));
        }else{
            System.out.println("Absolute Value : "+num);
        }

        // Find profit and loss through cost price and selling price
        System.out.println("Enter cost price: ");
        int cp=sc.nextInt();
        System.out.println("Enter selling price: ");
        int sp=sc.nextInt();
        if(sp>cp){
            System.out.println("Profit: "+ (sp-cp));
        }
        else if(sp==cp){
            System.out.println("No Profit No loss ");
        }
        else{
            System.out.println("loss: " + (cp-sp));
        }
        int z =15;
        if(z%3==0 && z%5==0) System.out.println("Divisible by both 5 and 3!");

        // Ternary operator
        System.out.println(((4%2==0) ? "even":"odd"));

        // Switch case
        System.out.println("Enter a exp: ");
        int g = sc.nextInt();
        int o = sc.next().charAt(0);
        int h = sc.nextInt();

        switch(o) {
            case '+': 
                System.out.println(g+h);
                break;
            case '-':
                System.out.println(g-h);
                break;
            case '*': 
                System.out.println(g*h);
                break;
            case '/':
                System.out.println(g/h);
            default :
                System.out.println(" Invalid operator");
        }
        
        char cha = 'a'; // or any other character
        boolean isLetter = Character.isLetter(cha);
        System.out.println(isLetter);

        // leap year
        System.out.println("Enter year: ");
        int year = sc.nextInt();
        if((year%4==0) && (year%100!=0) || (year%400==0)){
            System.out.println(year+" is a leap year");
        }
        else{
            System.out.println(year+" is not a leap year");
        }
    }
} 