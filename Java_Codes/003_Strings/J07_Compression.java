public class J07_Compression {
    public static void main(String[] args) {

        // string compression 

        // String s="aaabbuuuucddeff";
        // char[] arr=s.toCharArray();
        // String ans="";
        // int i=0;int j=0;
        // while(j<arr.length){
        //     if(arr[i]==arr[j]){
        //         j++;
        //     }else{
        //         ans=ans+arr[i];
        //         int len=(j-i);
        //         if(len>1) ans+=len;
        //         i=j;
        //     }
        // }
        // ans=ans+arr[i];
        // int len=(j-i);
        // if(len>1) ans+=len;

        // System.out.println(ans);

        // more optimised string builders
        
        String s="aaabbuuuucddeff";
        char[] arr=s.toCharArray();
        StringBuilder ans=new StringBuilder("");
        int i=0;int j=0;
        while(j<arr.length){
            if(arr[i]==arr[j]){
                j++;
            }else{
                ans.append(arr[i]);
                int len=(j-i);
                if(len>1) ans.append(len);
                i=j;
            }
        }
        ans.append(arr[i]);
        int len=(j-i);
        if(len>1) ans.append(len);
         
        System.out.println(ans);
    }
}
