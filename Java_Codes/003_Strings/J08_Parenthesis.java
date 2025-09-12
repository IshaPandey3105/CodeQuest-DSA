public class J08_Parenthesis {
    public static void main(String[] args) {

        String str = "(()())(())";       // original string
        StringBuilder sb = new StringBuilder(); // new string builder
        int open = 0;   

       for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                if (open > 0) {
                    sb.append(c);  // append only if not outermost
                }
                open++;
            } else { // c == ')'
                open--;
                if (open > 0) {
                    sb.append(c);  // append only if not outermost
                }
            }
        }
        System.out.println(sb);
    }
}
