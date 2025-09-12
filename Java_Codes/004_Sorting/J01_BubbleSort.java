public class J01_BubbleSort {

    // Printing The Array
    public static void print(int[] arr){
        for(int elem : arr){
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // ##### Bubble Sort --- [TC-O(n^2) & SC-O(n) & ASC-O(1)] ---> STABLE SORT

        int[] arr={1,5,2,4,4,0};
        int n=arr.length;

        // Method 1: Just swapping (no. of operations are more)
        // for(int p=0;p<n-1;p++){  // n-1 passes
        //     for(int i=0;i<n-1;i++){
        //         if(arr[i]>arr[i+1]){
        //             // swap
        //             int temp=arr[i];
        //             arr[i]=arr[i+1];
        //             arr[i+1]=temp;
        //         }
        //     }
        // }
        // print(arr);


        // // Method 2: swapping but knowing that in every pass biggest elem is to right posiion 
        // for(int p=0;p<n-1;p++){
        //     for(int i=0;i<n-1-p;i++){  // here's the change
        //         if(arr[i]>arr[i+1]){
        //             // swap
        //             int temp=arr[i];
        //             arr[i]=arr[i+1];
        //             arr[i+1]=temp;
        //         }
        //     }
        // }
        // print(arr);


        // Method 3: More Optimised by suing boolean checkpoints
        // so that at every pass , we can check if the array is sorted or not

        // Non- decreasing order
        // for(int p=0;p<n-1;p++){
        //     boolean flag=true;
        //     for(int i=0;i<n-1-p;i++){  // here's the change
        //         if(arr[i]>arr[i+1]){
        //             // swap
        //             int temp=arr[i];
        //             arr[i]=arr[i+1];
        //             arr[i+1]=temp;
        //             flag=false;
        //         }
        //         if(flag==true) break;   // break as it is sorted now
        //     }
        // }
        // print(arr);

        // decreasing order
        for(int p=0;p<n-1;p++){
            boolean flag=true;
            for(int i=0;i<n-1-p;i++){  // here's the change
                if(arr[i]<arr[i+1]){
                    // swap
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    flag=false;
                }
                if(flag==true) break;   // break as it is sorted now
            }
        }
        print(arr);
    }
}
