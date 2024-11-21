package DailyChallenge.Graph.CourseScheduleII.Approach_1;
// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;
class Solution {
    public int[] findOrder(final int numCourses, final int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new List[numCourses];
        int[] degree = new int[numCourses];

        for(int[] pre : prerequisites){
            if (adj[pre[0]] == null){
                adj[pre[0]] = new ArrayList<>();
            }
            adj[pre[0]].add(pre[1]);
            degree[pre[1]]++;
        }

        int count = numCourses-1;
        int[] ans = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0){
                queue.add(i);
                ans[count--] =  i;
            }
        }

        while (!queue.isEmpty()){
            int popped = queue.poll();

            for (int i = 0; adj[popped] != null && i < adj[popped].size(); i++) {
                 int n = adj[popped].get(i);
                 degree[n]--;

                 if (degree[n] == 0){
                     ans[count--] = n;
                     queue.add(n);
                 }
            }
        }

        return count < 0 ? ans : new int[0];
    }
}