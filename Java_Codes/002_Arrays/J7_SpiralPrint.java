public class J7_SpiralPrint {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int r = arr.length;
        int c = arr[0].length;

        int minr=0;
        int minc=0;
        int maxr=r-1;
        int maxc=c-1;


        while(minr <= maxr && minc <= maxc){

            // top row(left to right)-- row(i) is fixed
            for(int j=minc;j<=maxc;j++){
                System.out.print(arr[minr][j] +" ");
            }
            minr++;


            // right col(top to bottom)-- col(j) is fixed
            if (minr > maxr || minc > maxc) break;
            for(int i=minr;i<=maxr;i++){
                System.out.print(arr[i][maxc]+" ");
            }
            maxc--;


            //Bottom row (right to left)-- row(i) is fixed
            if (minr > maxr || minc > maxc) break;
                for (int j = maxc; j >= minc; j--) {
                    System.out.print(arr[maxr][j]+" ");
                }
                maxr--;


            // Left column(bottom to up)-- col is fixed
            if (minr > maxr || minc > maxc) break;
                for (int i = maxr; i >= minr; i--) {
                    System.out.print(arr[i][minc]+" ");
                }
                minc++;
        }
    }
}
