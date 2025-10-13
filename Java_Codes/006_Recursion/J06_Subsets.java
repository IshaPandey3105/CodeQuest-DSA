public class J06_Subsets {

    public static void subset(String s,String ans,int n){
        if(n==s.length()) {
            System.out.println(ans);
            return;
        }
        subset(s,ans,n+1);     // skip
        char ch=s.charAt(n);
        subset(s,ans+ch,n+1);  // take
    }
    public static void main(String[] args) {
        String s="abc";
        String ans="";
        subset(s,ans,0);
    }
}
