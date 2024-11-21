package DailyChallenge.Intervals.NonOverlappingIntervals.Approach_1;
// https://leetcode.com/problems/non-overlapping-intervals/
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int removedIntervals = 0;
        int[] firstInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] secondInterval = intervals[i];

            if (isOverlap(firstInterval, secondInterval)){
                // that's mean there is overlap, so we have to remove one
                removedIntervals++;

                if (firstInterval[1] > secondInterval[1]){
                    firstInterval = secondInterval;
                }
            }
            else {
                firstInterval = secondInterval;
            }
        }

        return removedIntervals;
    }
    public boolean isOverlap(int[] first, int[] second){
        return first[1] > second[0];
    }

}
