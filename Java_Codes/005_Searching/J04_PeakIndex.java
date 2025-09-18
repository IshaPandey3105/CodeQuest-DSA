public class J04_PeakIndex {
    public static void main(String[] args) {   
        int[] arr={10,20,30,50,60,40,10};
            int n=arr.length;
            int peakIndx=0;
            // int start=0 ; int end=n-1;
            int start=1 ; int end=n-2;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1] ){
                    peakIndx=mid;
                    break;
                }
                else if(arr[mid]<arr[mid+1]){     // right search
                    start=mid+1;
                }else if(arr[mid]<arr[mid-1]){    // left search
                    end=mid-1;
                }
            }
            System.out.println(peakIndx);

            // upper code will not work as mid+1 and mid_1 sometimes not valid
            // but what if its given that it has atleast 3 elem and we start them from 1 and end n-2

        // int start = 0, end = arr.length - 1;

        // while (start < end) {
        //     int mid = start + (end - start) / 2;

        //     if (arr[mid] < arr[mid + 1]) {
        //         // we are in the increasing slope
        //         start = mid + 1;
        //     } else {
        //         // we are in the decreasing slope (mid could be peak)
        //         end = mid;
        //     }
        // }

    }
}
