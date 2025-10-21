// import java.util.Scanner;

// public class J05_QuickSort {
//     public static void Print(int[] arr){
//         for(int elem : arr){
//             System.out.print(elem +" ");
//         }
//         System.out.println(" ");
//     }
//     public static void swap(int[] arr,int i,int j){
//        int temp=arr[i];
//        arr[i] = arr[j];
//        arr[j]=temp;
//     }
//     // Randomised pivot elem(middle)
//     // public static int R_Partition(int[] arr,int l,int h){
//     //     int mid=(l+h)/2;
//     //     int pivot=arr[mid], pivotIndex=mid;
//     //     //count smaller no. than pivot
//     //     int countSmaller=0;
//     //     for(int i=l;i<=h;i++){
//     //         if(i==mid) continue;
//     //         if(arr[i]<=pivot) countSmaller++;
//     //     }
//     //     int correctIndx= l+countSmaller;
//     //     // swapping
//     //     swap(arr,pivotIndex,correctIndx);
//     //     int i=l,j=h;
//     //     while(i<correctIndx && j>correctIndx){
//     //         if(arr[i]<=arr[correctIndx]) i++;
//     //         else if(arr[j]>arr[correctIndx]) j--;
//     //         else if(arr[i]>arr[correctIndx] && arr[correctIndx]>=arr[j]){
//     //             swap(arr,i,j);
//     //             i++;j--;
//     //         }
//     //     }
//     //     return correctIndx;
//     // }
//     public static int Partition(int[] arr,int l,int h){
//         int pivot=arr[l];
//         //count smaller no. than pivot
//         int countSmaller=0;
//         for(int i=l+1;i<=h;i++){
//             if(arr[i]<=pivot) countSmaller++;
//         }
//         int correctIndx= l+countSmaller;
//         // swapping
//         swap(arr,l,correctIndx);
//         int i=l,j=h;
//         while(i<correctIndx && j>correctIndx){
//             if(arr[i]<=arr[correctIndx]) i++;
//             else if(arr[j]>arr[correctIndx]) j--;
//             else if(arr[i]>arr[correctIndx] && arr[correctIndx]>=arr[j]){
//                 swap(arr,i,j);
//                 i++;j--;
//             }
//         }
//         return correctIndx;
//     }
//     public static void quickSort(int[] arr,int l,int h){
//         if(l>=h) return;
//         int pIndx=Partition(arr,l,h);
//         // int pIndx=R_Partition(arr,l,h);  // by this we get TC: O(nlogn) in worst case also
//         quickSort(arr,l,pIndx-1);
//         quickSort(arr,pIndx+1,h);
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Enter size of array : ");
//         int n=sc.nextInt();
//         int[] arr=new int[n];
//         System.out.print("Enter "+n+" elements in array : ");
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         Print(arr);
//         quickSort(arr,0,n-1);
//         Print(arr);
//         sc.close();
//     }
// }

// Quick Select
public class J05_QuickSort {
    public static void swap(int[] arr,int i,int j){
       int temp=arr[i];
       arr[i] = arr[j];
       arr[j]=temp;
    }
    public static int Partition(int[] arr,int l,int h){
        int pivot=arr[l];
        //count smaller no. than pivot
        int countSmaller=0;
        for(int i=l+1;i<=h;i++){
            if(arr[i]<=pivot) countSmaller++;
        }
        int correctIndx= l+countSmaller;
        // swapping
        swap(arr,l,correctIndx);
        int i=l,j=h;
        while(i<correctIndx && j>correctIndx){
            if(arr[i]<=arr[correctIndx]) i++;
            else if(arr[j]>arr[correctIndx]) j--;
            else if(arr[i]>arr[correctIndx] && arr[correctIndx]>=arr[j]){
                swap(arr,i,j);
                i++;j--;
            }
        }
        return correctIndx;
    }
    public static void quickselect(int[] arr,int l,int h,int k){
        if(l>h) return;
        int pIndx=Partition(arr,l,h);

        if(pIndx ==k-1){
            System.out.println(arr[pIndx]);
            return;
        }
        else if(pIndx > k-1) quickselect(arr,l,pIndx-1,k);
        else quickselect(arr,pIndx+1,h,k);
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,6};
        int n=arr.length;
        int k=4;   // 4th largest
        // quickselect(arr,0,n-1,k);
        quickselect(arr,0,n-1,n-k+1);
    }
}
