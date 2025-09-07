import java.util.Arrays;

public class J11_SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr={{1,1,1},{1,0,1},{1,1,1}};
        int m=arr.length;
        int n=arr[0].length;

// // Methode 1 - using a helper array   --- O(m*n)space
        
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(copy[i][j]==0){
        //             for(int r=0;r<m;r++){
        //                 arr[r][j]=0;
        //             }
        //             for(int c=0;c<n;c++){
        //                 arr[i][c]=0;
        //             }
        //         }
        //     }
        // }

        // // printing
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }


// // Methode 2 - using boolean array for only those particular row and col---- O(m+n)space

        // boolean[] row = new boolean[m];
        // boolean[] col = new boolean[n];

        // // Marking the particular row and col
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(arr[i][j]==0){
        //             row[i]=true;  // Marked
        //             col[j]=true;
        //         }
        //     }
        // }

        // // set the true rows to 0
        // for(int i=0;i<m;i++){
        //     if(row[i]==true){  // set the ith row to 0
        //         for(int j=0;j<n;j++){
        //             arr[i][j]=0;
        //         }
        //     }
        // }

        // // set the true col to 0
        // for(int j=0;j<n;j++){
        //     if(col[j]==true){   // set the jth col to 0
        //         for(int i=0;i<m;i++){
        //             arr[i][j]=0;
        //         }
        //     }
        // }

        // // printing
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }


// Method-3 The best way we use only some variables (constant O(1) Space)   

        boolean zeroRow=false;
        boolean zeroCol=false;

        // finding zero in 0th Row
        for(int j=0;j<n;j++){
            if(arr[0][j]==0){
                zeroRow=true;
            }
        }
        // finding zero in 0th Col
        for(int i=0;i<m;i++){
            if(arr[i][0]==0){
                zeroCol=true;
            }
        }

        // traversing in short array
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][j]==0){
                    arr[0][j]=0;
                    arr[i][0]=0;
                }
            }
        }

        // traversing 0th row 
        for(int j=1;j<n;j++){
            if(arr[0][j]==0){
                for(int i=1;i<m;i++){  // making that col 0
                    arr[i][j]=0;
                }
            }
        }

        // traversing 0th col 
        for(int i=1;i<m;i++){
            if(arr[i][0]==0){
                for(int j=1;j<n;j++){ // making that row 0
                    arr[i][j]=0;
                }
            }
        }

        // now using that zeroRow 
        if(zeroRow==true){
            for(int j=0;j<n;j++){
                arr[0][j]=0;
            }
        }
        // now using that zeroCol 
        if(zeroCol==true){
            for(int i=0;i<m;i++){
                arr[i][0]=0;
            }
        }
        
         // printing
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
