public class J06_Isomorphic {
    public static void main(String[] args) {
        // Finding whether two strings are isomorphoc or not

        String s="egg";
        String t="add";
        char[] arr=new char[128];  // by default '\0'

        // if(s.length()!=t.length()) return false;

        // loop for mapping s->t
        for(int i = 0; i < s.length(); i++){
            char ch=s.charAt(i);
            char dh=t.charAt(i);
            int index=(int)ch;
            if(arr[index]=='\0'){
                arr[index]=dh;
            }
            else{
                if(arr[index]!=dh) break;
            }
        }
        
        // making array again empty
        for(int i = 0; i < 128; i++){
            arr[i]='\0';
        }

        // loop for mapping s->t
        for(int i = 0; i < t.length(); i++){
            char ch=t.charAt(i);
            char dh=s.charAt(i);
            int index=(int)ch;
            if(arr[index]=='\0'){
                arr[index]=dh;
            }
            else{
                if(arr[index]!=dh) break;
            }
        }
        // return true;
    }
}
