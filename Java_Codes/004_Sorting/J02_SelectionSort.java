public class J02_SelectionSort {
    // Printing The Array
    public static void print(int[] arr){
        for(int elem : arr){
            System.out.print(elem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // ##### Slection Sort --- [TC-O(n^2) & SC-O(n) & ASC-O(1)] ---> UNSTABLE SORT

        int[] arr={1,5,2,4,4,0};
        int n=arr.length;

        // finding the kth smallest elem then swapping it to front of unsorted part (no. of operations are lesser than BS)
        for(int i=0;i<n-1;i++){  
            int min=Integer.MAX_VALUE;
            int minIndx=0;
            for(int j=i;j<n;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndx=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndx];
            arr[minIndx]=temp;
        }
        print(arr);
    }
}
