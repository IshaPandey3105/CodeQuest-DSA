public class J03_InsertionSort {

    // Printing The Array
    public static void print(int[] arr){
        for(int elem : arr){
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // ##### Insertion Sort --- [TC-O(n^2) & SC-O(n) & ASC-O(1)] -

        int[] arr={1,5,2,4,4,0};
        int n=arr.length;

        // asume sorted and unsorted parts then do swapping to the correct position(STABLE SORT)
        // for(int i=1;i<n;i++){  
        //     for(int j=i;j>=1;j--){
        //         if(arr[j]<arr[j-1]){
        //             int temp=arr[j];
        //             arr[j]=arr[j-1];
        //             arr[j-1]=temp;
        //         }
        //         else break;
        //     }
        // }
        // print(arr);


        // Using 2 conditions in for loop then we don't have to break explicitly
        // for(int i=1;i<n;i++){  
        //     for(int j=i;j>=1 && arr[j]<arr[j-1];j--){
        //         int temp=arr[j];
        //         arr[j]=arr[j-1];
        //         arr[j-1]=temp;
        //     }
        // }
        // print(arr);


        // Using while loop (Formal code)
        for(int i=1;i<n;i++){  
            int j=i;
            while(j>=1 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        print(arr);
    }
}
