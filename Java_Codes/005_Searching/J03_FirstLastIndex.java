public class J03_FirstLastIndex{
    public static void main(String[] args) {
        int[] arr={10,20,20,20,20,30,40,40,40,50,50,60};
        int n=arr.length;
        int target=20;
        int fp=0;  // first position
        int lp=0;  // last position
        int start=0 ; int end=n-1;
        // for fp
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                fp=mid;
                end=mid-1;
            }
            else if(arr[mid]>target){     // left search
                end=mid-1;
            }else{                   // right search
                start=mid+1;
            }
        }
        System.out.println(fp);


        // for lp
        start=0 ; end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                lp=mid;
                start=mid+1;
            }
            else if(arr[mid]>target){     // left search
                end=mid-1;
            }else{                   // right search
                start=mid+1;
            }
        }
        System.out.println(lp);
    }
}
