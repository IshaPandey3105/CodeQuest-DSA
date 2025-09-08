import java.util.Scanner;

public class J01_Basic {
    public static void main(String[] args) {

        char[] c= {'i','s','h','a'};
        System.out.println(c[2]);
        String str1;
        String str2;

        // Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name (1 word)");
        str1=sc.next();  // prints only 1st word
        System.out.println("Hi "+str1); // printing

        sc.nextLine(); // consume leftover newline from previous sc.next() so nextLine() works correctly
        // it clears the buffer

        System.out.println("Enter sentance");
        str2=sc.nextLine();  // prints whole sentance
        System.out.println(str2); // printing

        String s="I want Placements";
        System.out.println(s.charAt(5));
        System.out.println(s.length());


        // counting vowels in string
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println(count);


        // Printing all subString

        String str3="abcd";
        // Outer loop -> starting index
        for (int i = 0; i < str3.length(); i++) {
            String temp = ""; // reset for each new starting point

            // Inner loop -> ending index
            for (int j = i; j < str3.length(); j++) {
                temp += str3.charAt(j); // add char one by one
                System.out.println(temp); // print current substring
            }
        }
        sc.close();
    }
}
