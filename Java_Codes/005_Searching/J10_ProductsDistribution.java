import java.util.*;

public class J10_ProductsDistribution {

    // Function to check if we can distribute items with maxQty per store
    public static boolean canDistribute(int[] quantities, int n, int maxQty) {
        int m = quantities.length;
        int stores = 0;
        for (int i = 0; i < m; i++) {
            stores += (quantities[i] + maxQty - 1) / maxQty; // ceil division
        }
        return stores <= n;
    }

    // Function to find minimized maximum quantity per store
    public static int minimizedMaximum(int n, int[] quantities) {
        int max = Arrays.stream(quantities).max().getAsInt();
        int x = 1; // initial minimized maximum

        int start = 1, end = max;
        while (start <= end) { // TC = O(m * log(max))
            int mid = start + (end - start) / 2;
            if (canDistribute(quantities, n, mid)) { // possible
                x = mid;
                end = mid - 1;
            } else { // not possible
                start = mid + 1;
            }
        }
        return x;
    }

    // Main function to test
    public static void main(String[] args) {
        int[] quantities = {11, 6}; // example quantities
        int n = 6; // number of stores

        int result = minimizedMaximum(n, quantities);
        System.out.println("Minimized maximum quantity per store: " + result);
    }
}
