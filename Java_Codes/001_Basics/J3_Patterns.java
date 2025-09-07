import java.util.Scanner;

public class J3_Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r and c : ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(); // Rectangle
        for (int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                System.out.print((char)(i+64) + " ");
            }
            System.out.println();
        }

        System.out.println();   // Triangle
        for (int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* " );
                // System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println();    // Inverted Triangle
        for (int i=1;i<=r;i++){
            for(int j=1;j<=r-i+1;j++){
                System.out.print("* " );
            }
            System.out.println();
        }

        System.out.println();   // Alphabets + Numbers 
        for (int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                if(i%2==0){
                    System.out.print((char)(j+64) + " ");
                }else{
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        System.out.println();  // Odd Triangle
        for (int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print(2*j-1 + " ");
            }
            System.out.println();
        }

        System.out.println();  // floyd's Triangle
        int a=1;
        for (int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print(a++ + " ");
                // a++;
            }
            System.out.println();
        }

        System.out.println();  // star
        int mid=(r/2)+1;
        for (int i=1;i<=r;i++){
            for(int j=1;j<=r;j++){
                if(j==mid || i==mid){
                    System.out.print( "* ");
                }
                else{
                    System.out.print( "  ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
