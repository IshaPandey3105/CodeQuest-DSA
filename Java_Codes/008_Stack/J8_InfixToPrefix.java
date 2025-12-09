import java.util.Stack;

public class J8_InfixToPrefix {
    public static void main(String[] args) {
        String str = "8-(5+3)*4/6";
        System.out.println("Expression: " + str);

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // number
            if (ascii >= 48 && ascii <= 57) {
                val.push("" + ch);
            }
            // opening bracket
            else if (ch == '(') {
                op.push(ch);
            }
            // closing bracket
            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char opr = op.pop();
                    String t = opr + v1 + v2;
                    val.push(t);
                }
                op.pop(); // pop '('
            }
            // operator
            else {
                // for + and -
                if (ch == '+' || ch == '-') {
                    // solve all previous ops (except '(') becuz we can push them when '(' at top
                    while (!op.isEmpty() && op.peek() != '(') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char opr = op.pop();
                        String t = opr + v1 + v2;
                        val.push(t);
                    }
                    op.push(ch);
                }
                // for * and /
                else if (ch == '*' || ch == '/') {
                    // solve only if previous has same precedence (* or /)
                    while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char opr = op.pop();
                        String t = opr + v1 + v2;
                        val.push(t);
                    }
                    op.push(ch);
                }
            }
        }

        // solve remaining operators
        while (!op.isEmpty()) {
            String v2 = val.pop();
            String v1 = val.pop();
            char opr = op.pop();
            String t = opr + v1 + v2;
            val.push(t);
        }

        System.out.println("Prefix: " + val.peek());
    }
}
