package DailyChallenge.Intervals.NonOverlappingIntervals.Approach_2;

import java.util.Arrays;

class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;

        int count = 1;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[prev][1] <= intervals[i][0]) {
                prev = i;
                count++;
            }
        }

        return n - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
