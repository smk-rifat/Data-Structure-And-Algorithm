package DailyChallenge.Graph.CourseScheduleII.Approach_2;

import java.util.*;

class Solution {
    List<Integer> courseOrder = new ArrayList<>();
    public int[] findOrder(final int numCourses, final int[][] prerequisites){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> completed = new HashSet<>();

        for(int[] pre : prerequisites){
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!completed.contains(i)){
                if (!dfs(map, completed, i, new HashSet<>())){
                    return new int[]{};
                }
            }
        }
        int[] ans = new int[numCourses];
        int i = 0;
        for(int val : courseOrder){
            ans[i++] = val;
        }
        return ans;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> completed, int course, Set<Integer> currentPath){
        if (currentPath.contains(course)) return false; // that's mean we got cycle;
        if (completed.contains(course)) return true;

        currentPath.add(course);

        if (map.containsKey(course)){

            for (int neighbor : map.get(course)){
                if (!dfs(map, completed, neighbor, currentPath)){
                    return false;
                }
            }
        }
        currentPath.remove(course);
        completed.add(course);
        courseOrder.add(course);
        return true;
    }
}
