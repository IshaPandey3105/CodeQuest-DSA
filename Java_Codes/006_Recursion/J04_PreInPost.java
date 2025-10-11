public class J04_PreInPost {
    
    // Zig - Zag Pattern

    public static void pip(int n){
        if(n==0) return;
        System.out.println(n);  // pre
        pip(n-1);
        System.out.println(n);  // in
        pip(n-1); 
        System.out.println(n);  // post
    }
    public static void main(String[] args) {
        pip(3);
    }
}
