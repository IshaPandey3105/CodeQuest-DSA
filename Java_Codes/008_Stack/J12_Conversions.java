import java.util.Stack;
public class J12_Conversions {

    public static void PrefixToPostfix(String str){
        // move right to left for evaluation always in prefix
        // and here first v1 then v2 pop
        System.out.println("Expression: " + str);
        Stack<String> val = new Stack<>();
        for (int i = str.length()-1; i >=0; i--) {  // move from right to left
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // number
            if (ascii >= 48 && ascii <= 57) {
                val.push(ch + "");
            }
            else{
                String v1 = val.pop();
                String v2 = val.pop();
                String t = v1 + v2 + ch;
                val.push(t);
            }
        }
        System.out.println("Postfix exp: "+ val.peek());
    }

    public static void PrefixToInfix(String str){
        System.out.println("Expression: " + str);
        Stack<String> val = new Stack<>();
        for (int i = str.length()-1; i >=0; i--) {  // move from right to left
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // number
            if (ascii >= 48 && ascii <= 57) {
                val.push(ch + "");
            }
            else{
                String v1 = val.pop();
                String v2 = val.pop();
                String t = '('+v1 + ch + v2 +')' ;
                val.push(t);
            }
        }
        System.out.println("Infix exp: "+ val.peek());
    }

    public static void PostfixToInfix(String str){
        System.out.println("Expression: " + str);
        Stack<String> val = new Stack<>();
        for (int i = 0 ; i <str.length(); i++) {  // move from l to r 
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // number
            if (ascii >= 48 && ascii <= 57) {
                val.push(ch + "");
            }
            else{
                String v2 = val.pop();
                String v1 = val.pop();
                String t = '('+v1 + ch + v2 +')' ;
                val.push(t);
            }
        }
        System.out.println("Infix exp: "+ val.peek());
    }

    public static void PostfixToPrefix(String str){
        System.out.println("Expression: " + str);
        Stack<String> val = new Stack<>();
        for (int i = 0 ; i <str.length(); i++) {  // move from l to r 
            char ch = str.charAt(i);
            int ascii = (int)ch;

            // for number
            if (ascii >= 48 && ascii <= 57) {
                val.push(ch + "");
            }
            else{
                String v2 = val.pop();
                String v1 = val.pop();
                String t =  ch + v1 + v2  ;
                val.push(t);
            }
        }
        System.out.println("Prefix exp: "+ val.peek());
    }

    public static void main(String[] args) {

        String pre = "-8/*+5376";
        String post = "853+7*6/-";
        PrefixToPostfix(pre);
        PrefixToInfix(pre);
        PostfixToInfix(post);
        PostfixToPrefix(post);
    }
}
