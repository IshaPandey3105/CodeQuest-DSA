import java.util.ArrayList;

public class J07_Sequence {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void Yash_Sol(String num , int n , int k, int currNum){
        if(num.length() == k){
            ans.add(Integer.parseInt(num));
            return;
        }
        else if(currNum > n){  return;  }
        Yash_Sol(num+currNum,n,k,currNum+1);     // take
        Yash_Sol(num,n,k,currNum+1);     // skip
    }
    public static void main(String[] args) {

        Yash_Sol("", 7, 4, 1);
        System.out.println(ans);
        System.out.println(ans.size());
    }
}
