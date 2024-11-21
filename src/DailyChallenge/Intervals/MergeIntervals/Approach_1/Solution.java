package DailyChallenge.Intervals.MergeIntervals.Approach_1;
// https://leetcode.com/problems/merge-intervals/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals){

        Comparator<int[]> comp = (o1, o2) -> o1[0] - o2[0];

        Arrays.sort(intervals, comp);

        int[] currentIntervals = intervals[0];
        List<int[]> merged = new ArrayList<>();
        merged.add(currentIntervals);

        for (int[] interval : intervals){
            int currentEnd = currentIntervals[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart){
                currentIntervals[1] = Math.max(currentEnd, nextEnd);
            }
            else {
                currentIntervals = interval;
                merged.add(currentIntervals);
            }
        }

        int[][] result = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
