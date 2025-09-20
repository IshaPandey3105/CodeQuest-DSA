public class J11_KokoEatingBananas {

// TC: O(n*log(max))

    public static boolean isPossible(int[] piles, int h, int mid) {
        long H = 0;
        for (int i = 0; i < piles.length; i++) {
            // number of hours for current pile
            H += (piles[i] + mid - 1) / mid;  // ceil(piles[i]/mid)
        }
        return H <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 1;

        // find maximum pile
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int k = max; // answer
        int start = 1, end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(piles, h, mid)) {
                k = mid;
                end = mid - 1; // try smaller speed
            } else {
                start = mid + 1; // need larger speed
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
