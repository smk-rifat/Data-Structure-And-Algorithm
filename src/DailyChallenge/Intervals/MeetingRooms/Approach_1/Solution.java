package DailyChallenge.Intervals.MeetingRooms.Approach_1;
// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if (n == 1 || n == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // cost O(n log n)
        int[] currentMetting = intervals[0];

        for (int i = 1; i < n; i++) {
            int[] nextMeeting = intervals[i];
            if (currentMetting[1] > nextMeeting[0]){
                return false;
            } else {
                currentMetting = nextMeeting;
            }
         }

        return true;
    }
}