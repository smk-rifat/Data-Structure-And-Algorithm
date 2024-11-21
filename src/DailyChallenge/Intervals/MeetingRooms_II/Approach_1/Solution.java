package DailyChallenge.Intervals.MeetingRooms_II.Approach_1;
// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] -b[1]);
        pq.offer(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] earlyEnd = pq.poll();
            int[] currentMeeting = intervals[i];

            // if current meeting starts after earliest meeting ends or when ends then we can do this at same room
            if (currentMeeting[0] >= earlyEnd[1] ){
                earlyEnd[1] = currentMeeting[1];
            } else {
                pq.offer(currentMeeting);
            }

            pq.offer(earlyEnd);
        }

        return pq.size();
    }
}