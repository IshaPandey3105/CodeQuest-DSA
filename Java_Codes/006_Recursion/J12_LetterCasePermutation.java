import java.util.*;  // Import for List and ArrayList

public class J12_LetterCasePermutation {

    static List<String> ans = new ArrayList<>();

    public static void helper(String s, String current, int n) {
        if (n == s.length()) {
            ans.add(current);
            return;
        }

        char ch = s.charAt(n);
        if (Character.isLetter(ch)) {
            // choose lowercase
            helper(s, current + Character.toLowerCase(ch), n + 1);
            // choose uppercase
            helper(s, current + Character.toUpperCase(ch), n + 1);
        } else {
            // if it's a digit, just include it as is
            helper(s, current + ch, n + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        helper(input, "", 0);

        System.out.println("All letter case permutations:");
        for (String str : ans) {
            System.out.println(str);
        }
        sc.close();
    }
}
