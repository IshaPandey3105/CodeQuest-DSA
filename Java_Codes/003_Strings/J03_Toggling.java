public class J03_Toggling {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Isha PaNdEy22");
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            int ascii=(int)ch;
            if(ascii>=65 && ascii<=90){  // capital letter
                ascii+=32;
                ch=(char)ascii;  // small letter
                sb.setCharAt(i, ch);
            }
            else if(ascii>=97 && ascii<=122){  // small letter
                ascii-=32;
                ch=(char)ascii;  // capital letter
                sb.setCharAt(i, ch);
            }
            // ch=(char)ascii;  
            // sb.setCharAt(i, ch);
        }
        System.out.println(sb);
    }
}
