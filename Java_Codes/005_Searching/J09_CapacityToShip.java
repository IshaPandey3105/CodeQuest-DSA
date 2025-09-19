public class J09_CapacityToShip {

    public static int DaysCalulator(int[] weights, int n, int cap) {
        int d = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + weights[i] > cap) {
                d++;          // start new day
                sum = 0;      // reset
            }
            sum += weights[i]; // always load the package
        }
        return d;
    }


    public static void shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max=0;
        int sum=0;
        int d=1;
        int minCap=0;

        // calculating max ans sum
        for(int i=0;i<n;i++){
            if(weights[i]>max) max=weights[i];
            sum += weights[i];
        }
        int start = max; int end = sum;

        // Calculating min capasity through BS
        while(start <= end){
            int mid = start + (end-start)/2;
            // fn for calculating days at particular capacity
            d=DaysCalulator(weights,n,mid);
            if(d<=days){
                minCap=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        System.err.println(minCap); 
    }
    public static void main(String[] args) {
        int[] weights={3,2,2,4,1,4};
        int days=3;
        shipWithinDays(weights,days);
    }
}
