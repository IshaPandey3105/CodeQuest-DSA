//****************************|MERGE SORT|*****************************

import java.util.Scanner;
public class J04_MergeSort {
    public static void Print(int[] arr){
        for(int elem : arr){
            System.out.print(elem +" ");
        }
        System.out.println(" ");
    }
    public static void merge(int[] a, int[] b,int[] c){
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]) c[k++]=a[i++];
            else c[k++]=b[j++];
        }
        while(i<a.length) c[k++]=a[i++];
        while(j<b.length) c[k++]=b[j++];
    }
    public static void mergeSort(int[] arr){
        int n=arr.length;
        if(n==1) return;
        // creation of subarrays
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        // puting elem of arr into these subarrays
        for(int i=0;i<n/2;i++){
            a[i]=arr[i];
        }
        for(int j=0;j<n-n/2;j++){
            b[j]=arr[j+n/2];
        }
        // recursion magic for furthure devision
        mergeSort(a);
        mergeSort(b);
        // now Merge these 2 sorted arrays
        merge(a,b,arr);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+ n +" elem in array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Print(arr);  // For printing 
        mergeSort(arr);
        Print(arr); 
        sc.close();
    }
}

//****************************|INVERSIONS COUNT PROBLEM|******************************


// public class J04_MergeSort {
//     static int count=0;
//     public static void Inversion(int[] a, int[] b){
//         int i=0,j=0;
//         while(i<a.length && j<b.length){
//             if(a[i]>b[j]) {
//                 count += a.length-i ;
//                 j++;
//             }
//             else i++;
//         }
//     }
//     public static void merge(int[] a, int[] b,int[] c){
//         int i=0,j=0,k=0;
//         while(i<a.length && j<b.length){
//             if(a[i]<=b[j]) c[k++]=a[i++];
//             else { //a[i]>b[j]
//                 count += a.length-i ;
//                 c[k++]=b[j++];
//             }
//         }
//         while(i<a.length) c[k++]=a[i++];
//         while(j<b.length) c[k++]=b[j++];
//     }
//     public static void mergeCount(int[] arr){
//         int n=arr.length;
//         if(n==1) return;
//         // creation of subarrays
//         int[] a = new int[n/2];
//         int[] b = new int[n-n/2];
//         // puting elem of arr into these subarrays
//         for(int i=0;i<n/2;i++){
//             a[i]=arr[i];
//         }
//         for(int j=0;j<n-n/2;j++){
//             b[j]=arr[j+n/2];
//         }
//         // recursion magic for furthure devision
//         mergeCount(a);
//         mergeCount(b);
//         //Counting those pairs
//         // Inversion(a, b);
//         // now Merge these 2 sorted arrays
//         merge(a,b,arr);   // make a single line change and boom!
//     }
//     public static void main(String[] args) {
//         int[] arr={8,2,5,3,1,4};
//         mergeCount(arr);
//         System.out.println(count);
//     }
// }
