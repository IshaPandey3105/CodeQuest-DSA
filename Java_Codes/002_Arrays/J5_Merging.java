import java.util.Arrays;
 // Merging of to sorted arrays 
public class J5_Merging {
    public static void main(String[] args) {
        int[] arr1={23,45,67,89};
        int[] arr2={25,45,77,79,100};
        int[] arr3=new int[arr1.length + arr2.length];

        int i=0;
        int j=0;
        int k=0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k++]=arr1[i++];
            }
            else{
                arr3[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr3[k++]=arr1[i++];
        }
        while(j<arr2.length){
            arr3[k++]=arr2[j++];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
