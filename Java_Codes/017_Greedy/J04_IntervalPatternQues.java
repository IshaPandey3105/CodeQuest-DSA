import java.util.*;

/*
 * Interval Pattern Problems:
 * 1. Merge Intervals (LC 56)
 * 2. Non-overlapping Intervals (LC 435)
 * 3. Minimum Number of Arrows to Burst Balloons (LC 452)
 * 4. Meeting Rooms II (LC 253)
 *
 * Time Complexities:
 * All four problems require sorting first.
 * Sorting = O(n log n)
 */

public class J04_IntervalPatternQues {

    // ============================================================
    // 1. Merge Intervals (LeetCode 56)
    // ============================================================

    /*
     * Approach:
     * 1. Sort intervals by starting time.
     * 2. Keep first interval.
     * 3. If current interval overlaps with last merged interval,
     *    merge them.
     * 4. Otherwise add new interval.
     *
     * Time Complexity : O(n log n)
     * Space Complexity: O(n)
     */

    static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] last = list.get(list.size() - 1);

            if (intervals[i][0] <= last[1]) {

                last[1] = Math.max(last[1], intervals[i][1]);

            } else {

                list.add(intervals[i]);

            }
        }

        return list.toArray(new int[list.size()][]);
    }

    // ============================================================
    // 2. Non-overlapping Intervals (LeetCode 435)
    // ============================================================

    /*
     * Goal:
     * Remove minimum number of intervals so that
     * remaining intervals do not overlap.
     *
     * Greedy:
     * Always keep interval with smaller ending point.
     *
     * Time Complexity : O(n log n)
     * Space Complexity: O(1)
     */

    static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int remove = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {

                remove++;

            } else {

                prevEnd = intervals[i][1];
            }
        }

        return remove;
    }

    // ============================================================
    // 3. Minimum Number of Arrows to Burst Balloons (LC 452)
    // ============================================================

    /*
     * Same greedy idea as Non-overlapping Intervals.
     *
     * Sort according to ending coordinate.
     *
     * Shoot arrow at first balloon's end.
     *
     * If next balloon starts after current arrow,
     * we need another arrow.
     *
     * Time Complexity : O(n log n)
     * Space Complexity: O(1)
     */

    static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPos) {

                arrows++;

                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

    // ============================================================
    // 4. Meeting Rooms II (LeetCode 253)
    // ============================================================

    /*
     * Goal:
     * Find minimum number of meeting rooms.
     *
     * Approach:
     * 1. Sort meetings by start time.
     * 2. Use min heap storing ending times.
     * 3. If earliest ending meeting finishes before
     *    current starts, reuse room.
     * 4. Otherwise allocate new room.
     *
     * Heap size = rooms needed.
     *
     * Time Complexity : O(n log n)
     * Space Complexity: O(n)
     */

    static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= pq.peek()) {

                pq.poll();
            }

            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }

    // ============================================================
    // Utility Function
    // ============================================================

    static void printIntervals(int[][] arr) {

        for (int[] interval : arr) {

            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }

        System.out.println();
    }

    // ============================================================
    // Main Function
    // ============================================================

    public static void main(String[] args) {

        // ---------------- Merge Intervals ----------------

        int[][] mergeInput = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        System.out.println("Merge Intervals:");
        printIntervals(mergeIntervals(mergeInput));

        // ---------------- Non-overlapping Intervals ----------------

        int[][] overlapInput = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };

        System.out.println("\nErase Overlap Intervals:");
        System.out.println(eraseOverlapIntervals(overlapInput));

        // ---------------- Minimum Arrows ----------------

        int[][] balloons = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };

        System.out.println("\nMinimum Arrows:");
        System.out.println(findMinArrowShots(balloons));

        // ---------------- Meeting Rooms ----------------

        int[][] meetings = {
                {0,30},
                {5,10},
                {15,20}
        };

        System.out.println("\nMinimum Meeting Rooms:");
        System.out.println(minMeetingRooms(meetings));
    }
}