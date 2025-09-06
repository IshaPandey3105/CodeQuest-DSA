import java.util.Arrays;
import java.util.Scanner;

public class J2_TwoSum {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Key : ");
        int key=sc.nextInt();

            // two sum
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == key){
                    System.out.println(arr[i]+" , "+arr[j]);
                }
            }
        }

        // two pointer
        int i=0 ; int j=arr.length-1;
        while(i<=j){
            //swap
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
