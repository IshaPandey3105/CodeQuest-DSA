import java.util.Stack;

public class J07_Infix {
    public static void main(String[] args) {
        String str = "8-(5+3)*4/6";
        System.out.println("Expression: " + str);

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If digit, push to val stack
            if (ch >= '0' && ch <= '9') {
                val.push(ch - '0');
            }
            // If '(', push to op stack
            else if (ch == '(') {
                op.push(ch);
            }
            // If ')', solve till '('
            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char opr = op.pop();

                    if (opr == '+') val.push(v1 + v2);
                    else if (opr == '-') val.push(v1 - v2);
                    else if (opr == '*') val.push(v1 * v2);
                    else if (opr == '/') val.push(v1 / v2);
                }
                op.pop(); // pop '('
            }
            // If operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!op.isEmpty() && precedence(op.peek()) >= precedence(ch)) {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    char opr = op.pop();

                    if (opr == '+') val.push(v1 + v2);
                    else if (opr == '-') val.push(v1 - v2);
                    else if (opr == '*') val.push(v1 * v2);
                    else if (opr == '/') val.push(v1 / v2);
                }
                op.push(ch);
            }
        }

        // Solve remaining operators
        while (!op.isEmpty()) {
            int v2 = val.pop();
            int v1 = val.pop();
            char opr = op.pop();

            if (opr == '+') val.push(v1 + v2);
            else if (opr == '-') val.push(v1 - v2);
            else if (opr == '*') val.push(v1 * v2);
            else if (opr == '/') val.push(v1 / v2);
        }

        System.out.println("Result: " + val.pop());
    }

    // Define operator precedence
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }
}
