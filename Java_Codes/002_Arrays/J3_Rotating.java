import java.util.Arrays;

public class J3_Rotating {
    public static void main(String[] args) {
        // Rotate an array (using other array)
        int[] arr={1,2,3,4,5,6};
        int n=arr.length;
        int[] nums= new int[n];
        int k=2;
        int x=n-k-1;
        int y=n-1;
        for(int a=0;a<n;a++){
            if(x<=y){
                nums[a]=arr[y];
                y--;
                x++;
            }else{
                nums[a]=arr[a-k];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));

        // rotating of array without using other array
//(instead of using 3 while loops and writing everytime the same swapping conditions use fn)
        int i=0;
        int j=n-k-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        int p=n-k;
        int q=n-1;
        while(p<=q){
            int temp=arr[p];
            arr[p]=arr[q];
            arr[q]=temp;
            p++;
            q--;
        }
        i=0;
        j=n-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));


    }
}