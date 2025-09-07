public class J06_Array2D {
    public static void main(String[] args) {
        int[][] a={{1,2},{3,4},{5,6}};
        int[][] b={{1,2},{3,4},{5,6}};
        int n=a.length;
        int m=a[0].length;

        // finding sum of 2 matrix without using third
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum=a[i][j]+b[i][j];
                b[i][j]=sum;
            }
        }
        for(int[] elem:b){
            for(int x: elem){
                System.out.print(x+" ");
            }
            System.out.println();
        }

        System.out.println();

        //Transpose of matrix --- (column wise printing)
        int[][] Transpose=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Transpose[i][j]=a[j][i];
                System.out.print(Transpose[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        // transpose of sq matrix wihtout using another matrix
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}}; 
        int p=arr.length;
        for(int i=0;i<p;i++){
            for(int j=0;j<p;j++){
                if(j>i){
                    int temp =arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        // Rotating of matrix by 90 in clockwise
        int[][] arr1={{1,2,3},{4,5,6},{7,8,9}}; 
        int r=arr1.length;
        int c=arr1[0].length;
        // transpose
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(j>i){
                    int temp =arr1[i][j];
                    arr1[i][j]=arr1[j][i];
                    arr1[j][i]=temp;
                }
            }
        }
        // reversing 
        for(int i=0;i<r;i++){
            for(int j=0;j<c/2;j++){
                int temp =arr1[i][j];
                arr1[i][j]=arr1[i][c-1-j];
                arr1[i][c-1-j]=temp;
            }
        }
        // or 
        // for(int i=0;i<n;i++){
        //     int a=0; int b=n-1;
        //     while(a<b){
        //         int temp =arr1[i][a];
        //         arr1[i][a]=arr1[i][b];
        //         arr1[i][b]=temp;
        //         a++;
        //         b--;
        //     }
        // }
        for(int[] elem:arr1){
            for(int x: elem){
                System.out.print(x+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        // Printing in Wave form

        int[][] arr2={{1,2,3},{4,5,6},{7,8,9}}; 
        int rn=arr2.length;
        int cn=arr2[0].length;
        // transpose
        for(int i=0;i<rn;i++){
            // if(i%2==0){
            //     for(int j=0;j<cn;j++){
            //         System.out.print(arr2[i][j]);
            //     }
            // }
            // if(i%2!=0){
            //     for(int j=cn-1;j>=0;j--){
            //         System.out.print(arr2[i][j]);
            //     }
            // }
            for(int j=0;j<cn;j++){
                if(i%2==0){
                    System.out.print(arr2[i][j] + " ");
                }else{
                    System.out.print(arr2[i][cn-j-1] + " ");
                }
            }
            System.out.println();
        }
    }
}
