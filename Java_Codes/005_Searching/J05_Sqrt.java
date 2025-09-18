public class J05_Sqrt {
    public static void main(String[] args) {
        int x=14;
        // return (int)Math.sqrt(x); // Newton Raphsen method(fast quadratic convergence)
        int start=1; int end=x/2;
        int sq=0;
        if (x < 2){   // edge cases
            sq=x;
        }   
        else{    
            while(start<=end){
                int mid = start + (end-start)/2;
                sq = mid * mid;   // for overflow condition use long
                if(sq==x) {sq = mid; break;}
                else if(sq < x){   // move right
                    sq=mid;
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
        }
        System.out.println(sq);
    }
}
