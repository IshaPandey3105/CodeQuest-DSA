public class J06_RotatedSortedArray {

    public static int Binarysearch(int[] arr, int start,int end,int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){     // left search
                end=mid-1;
            }else{                   // right search
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int[] arr={3,4,5,6,7,0,1,2};  // rotated array
        int[] arr={2,5,6,8};  // not rotated array
        // int[] arr={6,7};
        int n=arr.length;
        int target=6;
        int start=1 ; int end=n-2;
        int p=-1;

        if(n<=2){
            // directly search
            for(int i=0;i<n;i++){
                if(arr[i]==target){
                 p=i;
                 break;
                }
            }
            System.out.println(p);
        }
        // find pivot(p)
        else {
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                    p=mid;
                    break;
                }
                else if(arr[mid-1] > arr[mid] && arr[mid] < arr[mid+1]){
                    p=mid-1;
                    break;
                }
                else {   
                    if(arr[mid]<arr[n-1]){
                        start=mid+1;
                    }else{                   
                        end=mid-1;
                    }
                }
            }

            if(p==-1){
                int q=Binarysearch(arr, 0, n-1, target);
                System.out.println(q);
            }
            else{
                int a=Binarysearch(arr,0,p,target);
                int b=Binarysearch(arr,p+1,n-1,target);
                // System.out.println(fp);

                if(a==-1 && b==-1) System.out.println(-1);
                else if(a!=-1) System.out.println(a);
                else System.out.println(b);
            }
        }
    }
}
