package DailyChallenge.Intervals.InsertInterval.Approach_1;
//https://leetcode.com/problems/insert-interval/
import java.util.*;


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = Arrays.copyOf(intervals, intervals.length+1);
        temp[temp.length-1] = newInterval;

        Comparator<int[]> comp = (a, b) -> a[0] - b[0];
        Arrays.sort(temp, comp);
        int[] currentInterval = temp[0];

        List<int[]> merged = new ArrayList<>();
        merged.add(currentInterval);

        for(int[] interval : temp){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        int[][] result = new int[merged.size()][2];

        for(int i = 0; i < merged.size(); i++){
            result[i] = merged.get(i);
        }

        return result;
    }
}