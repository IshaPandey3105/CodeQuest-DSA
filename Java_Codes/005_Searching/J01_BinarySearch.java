import java.util.Arrays;

public class J01_BinarySearch {
    public static void main(String[] args) {
        int[] arr={23,45,3,56,73,55,10};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        int target=10;
        boolean flag=false;
        int start=0 ; int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                flag=true;
                break;
            }
            else if(arr[mid]>target){     // left search
                end=mid-1;
            }else{                   // right search
                start=mid+1;
            }
        }
        if(flag==true){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
