package DailyChallenge.Intervals.MeetingRooms_II.Approach_2;

import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int res = 0;

        int s = 0;
        int e = 0;

        while (s < n){

            if (start[s] < end[e]){
                s++;
                rooms--;
            } else {
                e++;
                rooms++;
            }
            res = Math.max(rooms, res);
        }

        return res;
    }
}