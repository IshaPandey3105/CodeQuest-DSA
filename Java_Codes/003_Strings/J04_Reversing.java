public class J04_Reversing {
    public static void main(String[] args) {
        
        // reversing each word of string
        StringBuilder sb = new StringBuilder("i am    okay! ");
        int i = 0; // start index of a word

        for (int j = 0; j <= sb.length(); j++) {
            if (j == sb.length() || sb.charAt(j) == ' ') { // if we reach a space or the end of string, reverse the word
                if (i < j) { // only reverse if there's a word
                    reverse(sb, i, j - 1);
                }
                i=j+1; // move start to next word
            }
        }
        System.out.println(sb);
    }
    public static void reverse(StringBuilder sb,int i,int j){
         while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}
