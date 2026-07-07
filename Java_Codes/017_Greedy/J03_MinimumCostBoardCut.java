import java.util.Arrays;
import java.util.Collections;

// Greedy Approach:
// 1. Sort both horizontal and vertical cut costs in descending order.
// 2. Always perform the costlier cut first to minimize its multiplication later.
// 3. A horizontal cut crosses all current vertical pieces (cost × vc) and creates one more horizontal piece (hc++).
// 4. A vertical cut crosses all current horizontal pieces (cost × hc) and creates one more vertical piece (vc++).
// 5. Continue until all cuts are made and return the total minimum cost.

public class J03_MinimumCostBoardCut {

    public static int minimumCost(Integer[] horizontal, Integer[] vertical) {

        // Sort both arrays in descending order
        Arrays.sort(horizontal, Collections.reverseOrder());
        Arrays.sort(vertical, Collections.reverseOrder());

        int h = 0;      // Pointer for horizontal cuts
        int v = 0;      // Pointer for vertical cuts

        int hc = 1;     // Current number of horizontal pieces
        int vc = 1;     // Current number of vertical pieces

        int ans = 0;

        while (h < horizontal.length && v < vertical.length) {

            if (horizontal[h] >= vertical[v]) {

                // Horizontal cut crosses all vertical pieces
                ans += horizontal[h] * vc;

                // One more horizontal strip is created
                hc++;

                h++;

            } else {

                // Vertical cut crosses all horizontal pieces
                ans += vertical[v] * hc;

                // One more vertical strip is created
                vc++;

                v++;
            }
        }

        // Remaining horizontal cuts
        while (h < horizontal.length) {
            ans += horizontal[h] * vc;
            hc++;
            h++;
        }

        // Remaining vertical cuts
        while (v < vertical.length) {
            ans += vertical[v] * hc;
            vc++;
            v++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Integer[] horizontal = {2, 1, 3, 1, 4};
        Integer[] vertical = {4, 1, 2};

        System.out.println(minimumCost(horizontal, vertical));
    }
}