import java.util.Stack;
public class J11_PrefixEval {
    public static void main(String[] args) {
        String str = "-8/*+5376";
        System.out.println("Expression: " + str);
        
        // move right to left for evaluation
        // and here first v1 then v2 pop

        Stack<Integer> val = new Stack<>();
        for (int i = str.length()-1; i >=0; i--) {  // move from right to left
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // number
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            }
            else{
                int v1 = val.pop();
                int v2 = val.pop();
                if (ch == '+') val.push(v1 + v2);
                else if (ch == '-') val.push(v1 - v2);
                else if (ch == '*') val.push(v1 * v2);
                else if (ch == '/') val.push(v1 / v2);
            }
        }
        System.out.println(val.peek());
    }
}
